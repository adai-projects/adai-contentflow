package com.adaiadai.contentflow.representation.pmc.project.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * TopicIndexVO: 项目主页[VO]
 *
 * @author adai
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectIndexVO {

    /**
     * projectItemVoList: 项目条目视图对象集合
     */
    private List<ProjectItemVO> projectItemVoList;
}
