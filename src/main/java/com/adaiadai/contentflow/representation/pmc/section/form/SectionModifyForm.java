package com.adaiadai.contentflow.representation.pmc.section.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * SectionModifyForm: 类型修改表单
 *
 * @author adai
 */
@Data
public class SectionModifyForm {

    @NotBlank(message = "名称不能为空")
    @Size(min = 2, max = 20, message = "名称字符长度不能超出范围‘2~20’")
    private String name;

    @Size(max = 300, message = "描述字符串长度不能超过‘300’")
    private String description;

    public SectionModifyForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public SectionModifyForm() {}
}
