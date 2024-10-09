package com.adaiadai.contentflow.domain.model.pmc.project.version;

import com.adaiadai.contentflow.domain.model.AbstractValueObject;
import com.adaiadai.contentflow.exception.ProjectException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public class VersionId extends AbstractValueObject {
    private static final long serialVersionUID = 1L;

    @Column(name = "version_id_id")
    private String id;

    public VersionId(String id) {
        this();
        this.setId(id);
    }

    protected VersionId() {
        super();
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = id;
        } else {
            throw new ProjectException("版本ID不能为空");
        }
    }
}
