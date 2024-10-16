package com.adaiadai.contentflow.application.pmc;

import com.adaiadai.contentflow.application.iaa.IdentityApplicationService;
import com.adaiadai.contentflow.constant.ccp.ScopeConstant;
import com.adaiadai.contentflow.constant.pmc.ProjectConstant;
import com.adaiadai.contentflow.constant.pmc.VersionConstant;
import com.adaiadai.contentflow.domain.model.pmc.indentity.Creator;
import com.adaiadai.contentflow.domain.model.pmc.project.Project;
import com.adaiadai.contentflow.domain.model.pmc.project.ProjectId;
import com.adaiadai.contentflow.domain.model.pmc.project.version.Version;
import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;
import com.adaiadai.contentflow.exception.ProjectException;
import com.adaiadai.contentflow.representation.pmc.project.dto.ProjectItemDTO;
import com.adaiadai.contentflow.representation.pmc.project.form.ProjectConfigModifyForm;
import com.adaiadai.contentflow.representation.pmc.project.form.ProjectCreateForm;
import com.adaiadai.contentflow.representation.pmc.project.form.ProjectModifyForm;
import com.adaiadai.contentflow.representation.pmc.project.vo.*;
import com.adaiadai.contentflow.service.pmc.project.ProjectService;
import com.adaiadai.contentflow.service.pmc.translator.ProjectTranslator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author adai
 */
@Service
public class ProjectApplicationService {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectTranslator projectTranslator;

    @Autowired
    private AxisApplicationService axisApplicationService;
    @Autowired
    private VersionApplicationService versionApplicationService;
    @Autowired
    private IdentityApplicationService identityApplicationService;

    public Project getByProjectId(String projectId) {
        Project byProjectId = projectService.getByProjectId(new ProjectId(projectId));
        if (byProjectId == null) {
            throw new ProjectException("项目不存在，项目ID：" + projectId);
        }
        return byProjectId;
    }

    public ProjectItemVO getItemVoByProjectId(String projectId) {
        Project project = projectService.getByProjectId(new ProjectId(projectId));
        return projectTranslator.convertToItemVo(project);
    }

    /**
     * 获取项目详情，通过项目ID和版本ID
     *
     * @param projectId 项目ID[M]
     * @param versionId 版本ID[O]
     * @return 项目详情[VO]
     */
    public ProjectDetailVO getDetailVoByProjectId(String projectId, String versionId) {
        Version version;
        if (versionId != null && !"".equals(versionId.trim())) {
            version = versionApplicationService.getByVersionId(versionId);
        } else {
            version = versionApplicationService.getDefaultByProjectId(projectId);
        }
        Project project = projectService.getByProjectId(new ProjectId(projectId));
        return projectTranslator.convertToDetailVo(project, version);
    }

    public ProjectModifyForm getModifyFormByProjectId(String projectId) {
        return projectTranslator.convertToModifyForm(projectService.getByProjectId(new ProjectId(projectId)));
    }

    public ProjectConfigModifyForm getConfigModifyVoByProjectId(String projectId) {
        Project project = projectService.getByProjectId(new ProjectId(projectId));
        return projectTranslator.convertToConfigModifyVo(project);
    }

    public List<Project> list() {
        return null;
    }

    public List<ProjectAboveVO> listAboveVo() {
        List<Project> projectList = projectService.listByCreator(new Creator(identityApplicationService.identity()));
        if (projectList != null && projectList.size() > 0) {
            return projectTranslator.convertToAboveVo(projectList);
        } else {
            return null;
        }
    }

    public List<ProjectItemVO> listItemVoByIdentityPublic(String identity) {
        return projectTranslator.convertToItemVo(projectService.listByCreatorAndScope(new Creator(identity), ScopeConstant.SCOPE_PUBLIC));
    }

    public List<ProjectItemVO> listItemVoByIdentity() {
        List<Project> projectList = projectService.listByCreator(new Creator(identityApplicationService.identity()));
        if (projectList != null && projectList.size() > 0) {
            return projectTranslator.convertToItemVo(projectList);
        } else {
            return null;
        }
    }

    public List<ProjectItemVO> listAboveItemVoByCreatorExcludeProjectId(String projectId) {
        List<Project> projects = projectService.listByCreator(new Creator(identityApplicationService.identity()));
        projects.removeIf(project -> project.projectId().id().equals(projectId));
        return projectTranslator.convertToItemVo(projects);
    }

    public List<ProjectItemDTO> listItemByIdentity(String identity) {
        List<Project> projects = projectService.listByCreator(new Creator(identity));
        return projectTranslator.convertToItemDTO(projects);
    }

    public List<ProjectItemDTO> listItemByIdentityAndScope(String identity, Integer scope) {
        List<Project> projects = projectService.listByCreatorAndScope(new Creator(identity), scope);
        return projectTranslator.convertToItemDTO(projects);
    }

    public List<ProjectItemVO> listPublicTop() {
        List<Project> projectList = projectService.listByPropertyAndAboveProjectId(ProjectConstant.PROJECT_PROPERTY_PUBLIC
                , ProjectConstant.PROJECT_DEFAULT_ABOVE_ID);
        if (projectList != null && projectList.size() > 0) {
            return projectTranslator.convertToItemVo(projectList);
        } else {
            return null;
        }
    }

    public List<ProjectItemVO> listPrivatePublicTop() {
        List<Project> projectList = projectService.listByPropertyAndScopeAndScopeAndAboveProjectId(ProjectConstant.PROJECT_PROPERTY_PRIVATE
                , ScopeConstant.SCOPE_PUBLIC
                , ProjectConstant.PROJECT_DEFAULT_ABOVE_ID);
        if (projectList != null && projectList.size() > 0) {
            return projectTranslator.convertToItemVo(projectList);
        } else {
            return null;
        }
    }

    public List<ProjectManageVO> listManageVoByIdentity() {
        List<Project> projectList = projectService.listByCreator(new Creator(identityApplicationService.identity()));
        if (projectList != null && projectList.size() > 0) {
            return projectTranslator.convertToManageVo(projectList);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public ProjectBaseVO post(ProjectCreateForm projectCreateForm) {
        ProjectId projectId = projectService.nextIdentity();
        String projectName = projectCreateForm.getName();
        Creator creator = new Creator(identityApplicationService.identity());
        // 判断该用户是否已经创建该项目，防止重复提交
        Project byCreatorAndName = projectService.getByCreatorAndName(creator, projectName);
        if (byCreatorAndName != null) {
            throw new ProjectException("项目已创建！");
        }
        Project project = new Project(projectId, creator, projectName);
        project.setDescription(projectCreateForm.getDescription());
        project.setWebsite(projectCreateForm.getWebsite());
        project.setScope(projectCreateForm.getScope());
        project.setContributionNotAllowed(projectCreateForm.getContributionNotAllowed());
        project.setAboveProjectId(projectCreateForm.getAboveProjectId());
        // 添加默认版本
        VersionId versionId = versionApplicationService.nextIdentity();
        Version version = new Version(versionId, projectId, projectName + VersionConstant.VERSION_DEFAULT_NAME_SUFFIX);
        version.setRank(versionApplicationService.listByProjectId(projectId.id()).size());
        versionApplicationService.save(version);
        projectService.save(project);
        return projectTranslator.convertToBaseVo(project);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateById(ProjectId projectId, ProjectModifyForm projectModifyForm) {
        Project originalProject = projectService.getByProjectId(projectId);
        // 属性复制
        BeanUtils.copyProperties(projectModifyForm, originalProject, "id");
        projectService.save(originalProject);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void patchOnConfig(String projectId, ProjectConfigModifyForm projectConfigModifyForm) {
        Project byProjectId = projectService.getByProjectId(new ProjectId(projectId));
        byProjectId.setScope(projectConfigModifyForm.getScope());
        byProjectId.setContributionNotAllowed(projectConfigModifyForm.getContributionNotAllowed());
        projectService.save(byProjectId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public ProjectBaseVO putByProjectId(String projectId, ProjectModifyForm projectModifyForm) {
        Project byProjectId = projectService.getByProjectId(new ProjectId(projectId));
        // 可修改的项目字段：名称，描述，网站地址和上级ID。参考 ProjectModifyForm
        // 校验修改内容的名称，如果修改内容涉及名称，则需要判断新的名称是否存在
        if (!byProjectId.name().equals(projectModifyForm.getName())) {
            Project byCreatorAndName = projectService.getByCreatorAndName(byProjectId.creator()
                    , projectModifyForm.getName());
            if (byCreatorAndName != null) {
                throw new ProjectException("项目已存在！");
            }
        }
        byProjectId.setName(projectModifyForm.getName());
        byProjectId.setDescription(projectModifyForm.getDescription());
        byProjectId.setWebsite(projectModifyForm.getWebsite());
        String aboveProjectId = projectModifyForm.getAboveProjectId();
        if (aboveProjectId != null && !"".equals(aboveProjectId.trim())) {
            byProjectId.setAboveProjectId(aboveProjectId);
        } else {
            byProjectId.setAboveProjectId(ProjectConstant.PROJECT_DEFAULT_ABOVE_ID);
        }
        projectService.update(byProjectId);
        return projectTranslator.convertToProjectBaseVo(byProjectId);
    }

    public void deleteByProjectId(String projectId) {
        Project project = projectService.getByProjectId(new ProjectId(projectId));
        // 项目级别：关联子项目处理
        List<Project> belowProjectList = projectService.listByAboveProjectId(project.projectId().id());
        if (!belowProjectList.isEmpty()) {
            // for强循环用户遍历，不修改数据
            for (int i = 0; i < belowProjectList.size(); i++) {
                Project temp = belowProjectList.get(i);
                temp.setAboveProjectId(ProjectConstant.PROJECT_DEFAULT_ABOVE_ID);
                belowProjectList.set(i, temp);
            }
            projectService.addAll(belowProjectList);
        }
        // 坐标级别
        axisApplicationService.deleteAllByProjectId(projectId);
        // 版本级别
        versionApplicationService.deleteAllByProjectId(projectId);
        // 删除项目
        projectService.remove(projectService.getByProjectId(project.projectId()));
    }

}
