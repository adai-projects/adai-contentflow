package com.adaiadai.contentflow.representation.ccp.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.ccp.blog.BlogBase;
import com.adaiadai.contentflow.representation.sis.reader.vo.ReadingAtProductOutlineVO;
import com.adaiadai.contentflow.representation.sis.tag.vo.TagItemVO;

import java.util.List;

/**
 * BlogCardVO: 博客卡片[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogCardVO extends BlogBaseVO {

    private ReadingAtProductOutlineVO readerAtProductOutlineVo;
    private List<TagItemVO> tagItemVoList;

    public BlogCardVO(BlogBase blogBase) {
        super(blogBase);
    }

    public BlogCardVO() {
    }
}
