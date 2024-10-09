package com.adaiadai.contentflow.representation.pmc.project.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.project.ProjectBase;

/**
 * ProjectItemVO: 项目条目[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectItemVO extends ProjectBaseVO {
    public ProjectItemVO(ProjectBase projectBase) {
        super(projectBase);
    }

    public ProjectItemVO() {
    }
}
