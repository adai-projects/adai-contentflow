package com.adaiadai.contentflow.representation.ccp.blog.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * BlogConfigModifyForm: 博客配置修改[FORM]
 *
 * @author adai
 */
@Data
public class BlogConfigModifyForm {

    private final String title;

    // 可修改字段~
    // =================================================================================================================

    @NotNull(message = "范围不能为空")
    private final Integer scope;

    @NotNull(message = "收录是否允许不能为空")
    private final Integer collectionNotAllowed;

    public BlogConfigModifyForm (String title, Integer scope, Integer collectionNotAllowed) {
        this.title = title;
        this.scope = scope;
        this.collectionNotAllowed = collectionNotAllowed;
    }
}
