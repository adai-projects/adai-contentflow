package com.adaiadai.contentflow.representation.sis.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.adaiadai.contentflow.constant.sis.TagConstant;

/**
 * TagAtProductDTO: 博客标签[DTO]
 *
 * @author adai
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagAtProductDTO {

    private String tagId;
    private String tagName;

    /**
     * labeled: 是否标记
     * <p>当前用户是否使用标签标记博客</p>
     * <p>
     * 0-未标记 {@link TagConstant#TAG_OF_BLOG_IS_LABELED_NOT}
     * 1-已标记 {@link TagConstant#TAG_OF_BLOG_IS_LABELED_YES}
     * </p>
     */
    private Integer labeled;

    /**
     * counter: 计数器
     * <p>标签标记博客的次数</p>
     */
    private Integer counter;
}
