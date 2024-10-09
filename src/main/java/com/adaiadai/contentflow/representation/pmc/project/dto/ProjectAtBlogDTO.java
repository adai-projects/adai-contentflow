package com.adaiadai.contentflow.representation.pmc.project.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.adaiadai.contentflow.domain.model.pmc.project.Project;
import org.springframework.beans.BeanUtils;

/**
 * ProjectAtBlogDTO: 项目博客[DTO]
 *
 * @author adai
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProjectAtBlogDTO extends ProjectBaseDTO {

    /**
     * collected: 是否收录
     * aspect: #2
     */
    private Integer collected;

    public static ProjectAtBlogDTO convert(Project project) {
        ProjectAtBlogDTO projectAtBlogDTO = new ProjectAtBlogDTO();
        BeanUtils.copyProperties(project, projectAtBlogDTO);
        return projectAtBlogDTO;
    }
}
