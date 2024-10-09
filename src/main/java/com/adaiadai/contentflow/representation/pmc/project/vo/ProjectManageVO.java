package com.adaiadai.contentflow.representation.pmc.project.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.project.ProjectBase;

/**
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectManageVO extends ProjectBaseVO {

    public ProjectManageVO(ProjectBase projectBase) {
        super(projectBase);
    }

    public ProjectManageVO() {
    }
}
