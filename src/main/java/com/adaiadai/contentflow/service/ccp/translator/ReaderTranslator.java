package com.adaiadai.contentflow.service.ccp.translator;

import com.adaiadai.contentflow.representation.sis.reader.dto.ReadingAtProductOutlineDTO;
import com.adaiadai.contentflow.representation.sis.reader.vo.ReadingAtProductOutlineVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author adai
 */
@Service("ccpReaderTranslator")
public class ReaderTranslator {

    public ReadingAtProductOutlineVO convertToReaderAtProductVo(ReadingAtProductOutlineDTO readingAtProductOutlineDto) {
        ReadingAtProductOutlineVO readingAtProductOutlineVo = new ReadingAtProductOutlineVO();
        BeanUtils.copyProperties(readingAtProductOutlineDto, readingAtProductOutlineVo);
        return readingAtProductOutlineVo;
    }
}
