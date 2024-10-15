package com.adaiadai.contentflow.domain.model.pmc.project.version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.adaiadai.contentflow.domain.model.IdentifiedEntityObject;
import com.adaiadai.contentflow.domain.model.pmc.project.ProjectId;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Version: 版本
 *
 * @author adai
 */
@Entity
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
public class Version extends IdentifiedEntityObject {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "版本ID不能为空")
    @Embedded
    private VersionId versionId;

    @NotNull(message = "版本名称不能为空")
    @Column
    private String name;

    @Column
    private String description;

    @NotNull(message = "版本项目ID不能为空")
    @Embedded
    private ProjectId projectId;

    @Column(name = "`rank`")
    private Integer rank;

    public Version(VersionId versionId, ProjectId projectId, String name, String description, Integer rank) {
        this();
        this.setVersionId(versionId);
        this.setProjectId(projectId);
        this.setName(name);
        this.setDescription(description);
        this.setRank(rank);
    }

    public Version(VersionId versionId, ProjectId projectId, String name) {
        this(versionId, projectId, name, null ,null);
    }

    protected Version() {
        super();
    }

    public VersionId versionId() {
        return this.versionId;
    }

    public ProjectId projectId() {
        return this.projectId;
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return this.description;
    }

    public Integer rank() {
        return this.rank;
    }


    public void setVersionId(VersionId versionId) {
        this.versionId = versionId;
    }

    public void setProjectId(ProjectId projectId) {
        this.projectId = projectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        if (description != null && !"".equals(description.trim())) {
            this.description = description;
        } else {
            this.description = this.name();
        }
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Version{" +
                "versionId=" + versionId +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rank=" + rank +
                '}';
    }
}
