package com.adaiadai.contentflow.representation.pmc.project.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.project.ProjectBase;

/**
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectAboveVO extends ProjectBaseVO {

    public ProjectAboveVO(ProjectBase projectBase) {
        super(projectBase);
    }

    public ProjectAboveVO() {
    }

}
