package com.adaiadai.contentflow.service.sis;

import com.adaiadai.contentflow.representation.ccp.blog.dto.BlogCardDTO;
import com.adaiadai.contentflow.representation.ccp.blog.vo.BlogCardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service("sisBlogTranslator")
public class BlogTranslator {

    private BlogCardVO convertToCardVo(BlogCardDTO blogCardDto) {
        if (blogCardDto != null) {
            BlogCardVO cardVo = new BlogCardVO();
            BeanUtils.copyProperties(blogCardDto, cardVo);
            return cardVo;
        } else {
            return null;
        }
    }

    public List<BlogCardVO> convertToCardVo(List<BlogCardDTO> blogCardDtos) {
        if (blogCardDtos != null && blogCardDtos.size() > 0) {
            List<BlogCardVO> cardVos = new ArrayList<>(blogCardDtos.size());
            blogCardDtos.forEach(blogCardDto -> cardVos.add(this.convertToCardVo(blogCardDto)));
            return cardVos;
        } else {
            return null;
        }
    }
}
