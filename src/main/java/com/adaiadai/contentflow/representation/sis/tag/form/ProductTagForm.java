package com.adaiadai.contentflow.representation.sis.tag.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author adai
 */
@Data
public class ProductTagForm {

    @NotNull
    private String productType;
    @NotNull
    private String tagId;
}
