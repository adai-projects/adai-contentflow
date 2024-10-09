package com.adaiadai.contentflow.representation.ccp.blog.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.ccp.blog.BlogBase;

/**
 * BlogDetailDTO: 博客详情[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogDetailDTO extends BlogBaseDTO {
    private static final long serialVersionUID = 1L;

    private Boolean authored;

    public BlogDetailDTO(BlogBase blogBase) {
        super(blogBase);
    }

    public BlogDetailDTO() {
    }
}
