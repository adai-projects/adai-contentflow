package com.adaiadai.contentflow.domain.model.ccp.product.snippet;

import com.adaiadai.contentflow.domain.model.AbstractValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public class SnippetId extends AbstractValueObject {

    @Column(name = "snippet_id_id", nullable = false, columnDefinition = "VARCHAR(50) COMMENT '片段ID'")
    private String id;

    public SnippetId(String id) {
        this();
        this.setId(id);
    }

    protected SnippetId() {
        super();
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SnippetId{" +
                "id='" + id + '\'' +
                '}';
    }
}
