package com.adaiadai.contentflow.domain.model.pmc.project;

import com.adaiadai.contentflow.domain.model.AbstractValueObject;
import com.adaiadai.contentflow.exception.ProjectException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public class ProjectId extends AbstractValueObject {
    private static final long serialVersionUID = 1L;

    @Column(name = "project_id_id")
    private String id;

    public ProjectId(String id) {
        this();
        this.setId(id);
    }

    protected ProjectId() {
        super();
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        if (id != null) {
            this.id = id;
        } else {
            throw new ProjectException("项目ID不能为空");
        }
    }
}
