package com.adaiadai.contentflow.application.sis;

import com.adaiadai.contentflow.application.iaa.IdentityApplicationService;
import com.adaiadai.contentflow.constant.ResultEnum;
import com.adaiadai.contentflow.constant.sis.ReadingConstant;
import com.adaiadai.contentflow.domain.model.sis.identity.Reader;
import com.adaiadai.contentflow.domain.model.sis.product.Product;
import com.adaiadai.contentflow.domain.model.sis.reading.Reading;
import com.adaiadai.contentflow.exception.MxException;
import com.adaiadai.contentflow.representation.sis.reader.dto.ReadingAtProductOutlineDTO;
import com.adaiadai.contentflow.representation.sis.reader.vo.ReadingAtProductOutlineVO;
import com.adaiadai.contentflow.service.sis.ReadingService;
import com.adaiadai.contentflow.service.sis.ReadingTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author adai
 */
@Service
public class ReadingApplicationService {

    @Autowired
    private ReadingService readingService;

    @Autowired
    private ReadingTranslator readingTranslator;

    @Autowired
    private IdentityApplicationService identityApplicationService;

    /**
     * 获取产品的阅读信息
     *
     * @param productId   产品ID
     * @param productType 产品类型
     * @return 产品阅读[DTO]
     */
    public ReadingAtProductOutlineDTO getReaderAtProductOutlineDtoByProduct(String productId, String productType) {
        return readingTranslator.convertToReaderAtProductDto(readingService.listByProduct(new Product(productId, productType)));
    }

    public ReadingAtProductOutlineVO getReaderAtProductOutlineVoByProduct(String productId, String productType) {
        return readingTranslator.convertToReaderAtProductVo(readingService.listByProduct(new Product(productId, productType)));
    }

    public Reading getOfReaderByProduct(String productId, String productType) {
        return readingService.getByReaderAndProduct(new Reader(identityApplicationService.identity()), new Product(productId, productType));
    }

    @Transactional(rollbackFor = {Exception.class})
    public Reading updateOfReaderByProduct(String productId, String productType, String status) {
        Reading reading = readingService.getByReaderAndProduct(new Reader(identityApplicationService.identity()),
                new Product(productId, productType));
        // 如果阅读为空，则断定当前用户是该博客的博主
        // 用户不能对自己的博客进行表态
        if (reading == null) {
            throw new MxException(ResultEnum.READER_FAILURE_ON_ABSENT.getCode().toString()
                    , ResultEnum.READER_FAILURE_ON_ABSENT.getMessage());
        }
        // 阅读表态
        // 表态：已喜欢
        if (ReadingConstant.READER_STATUS_LIKE.equalsIgnoreCase(status)) {
            reading.setLiked(ReadingConstant.READER_LIKED_YES);
            reading.setDisliked(ReadingConstant.READER_DISLIKED_NOT);
        }
        // 表态：不喜欢
        if (ReadingConstant.READER_STATUS_DISLIKE.equalsIgnoreCase(status)) {
            reading.setDisliked(ReadingConstant.READER_DISLIKED_YES);
            reading.setLiked(ReadingConstant.READER_LIKED_NOT);
        }
        readingService.update(reading);
        return readingService.getByReaderAndProduct(reading.reader(), reading.product());
    }

}
