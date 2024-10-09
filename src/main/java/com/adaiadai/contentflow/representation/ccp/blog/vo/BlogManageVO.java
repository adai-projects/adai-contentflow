package com.adaiadai.contentflow.representation.ccp.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.ccp.blog.BlogBase;

/**
 * BlogManageVO: 博客管理[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogManageVO extends BlogBaseVO {

    public BlogManageVO(BlogBase blogBase) {
        super(blogBase);
    }

    protected BlogManageVO() {
    }
}
