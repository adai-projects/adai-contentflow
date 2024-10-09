package com.adaiadai.contentflow.domain.model.pmc.project.subject;

import com.adaiadai.contentflow.domain.model.AbstractValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public class SubjectId extends AbstractValueObject {
    private static final long serialVersionUID = 1L;

    @Column(name = "subject_id_id")
    private String id;

    public SubjectId(String id) {
        this();
        this.setId(id);
    }

    protected SubjectId() {
        super();
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        if (id != null && !"".equals(id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("专题ID不能为空");
        }
    }
}
