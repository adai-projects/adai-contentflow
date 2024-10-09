package com.adaiadai.contentflow.representation.pmc.project.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.project.ProjectBase;

/**
 * ProjectItemDTO: 项目条目[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectItemDTO extends ProjectBaseDTO {
    private static final long serialVersionUID = 1L;

    public ProjectItemDTO(ProjectBase projectBase) {
        super(projectBase);
    }

    public ProjectItemDTO() {
    }
}
