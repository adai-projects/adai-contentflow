package com.adaiadai.contentflow.domain.model.ccp.product.book;

import com.adaiadai.contentflow.domain.model.AbstractValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public class BookId extends AbstractValueObject {
    private static final long serialVersionUID = 1L;

    @Column(name = "book_id_id", unique = true, nullable = false, columnDefinition = "VARCHAR(50) COMMENT '图书ID'")
    private String id;

    public BookId(String id) {
        this();
        this.setId(id);
    }

    protected BookId() {
        super();
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
