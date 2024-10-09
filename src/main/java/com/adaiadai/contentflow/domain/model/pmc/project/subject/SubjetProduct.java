package com.adaiadai.contentflow.domain.model.pmc.project.subject;


import com.adaiadai.contentflow.domain.model.IdentifiedValueObject;
import com.adaiadai.contentflow.domain.model.pmc.product.Product;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * @author adai
 */
@Entity
public class SubjetProduct extends IdentifiedValueObject {

    @Embedded
    private SubjectId subjectId;
    @Embedded
    private Product product;

    @Column
    private Integer verified;
}
