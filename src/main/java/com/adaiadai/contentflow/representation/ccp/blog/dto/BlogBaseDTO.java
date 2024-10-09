package com.adaiadai.contentflow.representation.ccp.blog.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.ccp.blog.BlogBase;

import java.io.Serializable;

/**
 * BlogBaseDTO: 博客基础[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BlogBaseDTO extends BlogBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public BlogBaseDTO(BlogBase blogBase) {
        super(blogBase);
    }

    public BlogBaseDTO() {

    }
}
