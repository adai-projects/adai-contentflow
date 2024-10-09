package com.adaiadai.contentflow.representation.ccp.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.ccp.blog.BlogBase;

/**
 * BlogBaseVO: 博客基本[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogBaseVO extends BlogBase {

    public BlogBaseVO(BlogBase blogBase) {
        super(blogBase);
    }

    public BlogBaseVO() {
    }
}
