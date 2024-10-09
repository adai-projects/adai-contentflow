package com.adaiadai.contentflow.representation.pmc.project.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.project.ProjectBase;
import com.adaiadai.contentflow.representation.pmc.section.vo.SectionItemVO;
import com.adaiadai.contentflow.representation.pmc.subject.vo.SubjectItemVO;
import com.adaiadai.contentflow.representation.pmc.version.vo.VersionItemVO;

import java.util.List;

/**
 * ProjectDetailVO: 项目详情[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectDetailVO extends ProjectBaseVO {

    private VersionItemVO appointedVersionVo;
    private List<VersionItemVO> versionItemVoList;
    private List<SubjectItemVO> subjectItemVoList;
    private List<SectionItemVO> sectionItemVoList;
    private ProjectItemVO aboveProjectItemVo;
    private List<ProjectItemVO> belowProjectItemVoList;

    public ProjectDetailVO(ProjectBase projectBase) {
        super(projectBase);
    }

    public ProjectDetailVO() {
    }

}
