package com.adaiadai.contentflow.repository.pmc;

import com.adaiadai.contentflow.domain.model.pmc.indentity.Creator;
import com.adaiadai.contentflow.domain.model.pmc.project.Project;
import com.adaiadai.contentflow.domain.model.pmc.project.ProjectId;
import com.adaiadai.contentflow.domain.model.pmc.project.ProjectRepository;
import com.adaiadai.contentflow.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author adai
 */
@Component
public class HibernateProjectRepository implements ProjectRepository {

    private final static String PROJECT_ID_PREFIX = "pmc-project-";

    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    @Override
    public ProjectId nextIdentity() {
        return new ProjectId(PROJECT_ID_PREFIX + UUIDUtil.getUuidPartOne());
    }

    @Override
    public Project projectOfProjectId(ProjectId projectId) {
        return projectJpaRepository.findByProjectId(projectId);
    }

    @Override
    public Project projectOfCreatorAndName(Creator creator, String name) {
        return projectJpaRepository.findByCreatorAndName(creator, name);
    }

    @Override
    public Collection<Project> projectsOfCreator(Creator creator) {
        return projectJpaRepository.findAllByCreator(creator);
    }

    @Override
    public Collection<Project> projectsOfCreatorAndScope(Creator creator, Integer scope) {
        return projectJpaRepository.findAllByCreatorAndScope(creator, scope);
    }

    @Override
    public Collection<Project> projectsOfProperty(Integer perproty) {
        return projectJpaRepository.findAllByProperty(perproty);
    }


    @Override
    public Collection<Project> projectsOfPropertyAndScopeAndAboveProjectId(Integer property, Integer scope, String aboveProjectId) {
        return projectJpaRepository.findAllByPropertyAndScopeAndAboveProjectId(property, scope, aboveProjectId);
    }

    @Override
    public Collection<Project> projectsOfPropertyAndAboveProjectId(Integer property, String aboveProjectId) {
        return projectJpaRepository.findAllByPropertyAndAboveProjectId(property, aboveProjectId);
    }

    @Override
    public Collection<Project> projectsOfScope(Integer scope) {
        return projectJpaRepository.findAllByScope(scope);
    }

    @Override
    public Collection<Project> projectsOfAboveProjectId(String aboveProjectId) {
        return projectJpaRepository.findAllByAboveProjectId(aboveProjectId);
    }

    @Override
    public Collection<Project> projectsOfAboveProjectIdAndScope(String aboveProjectId, Integer scope) {
        return projectJpaRepository.findAllByAboveProjectIdAndScope(aboveProjectId, scope);
    }

    @Override
    public void add(Project project) {
        projectJpaRepository.save(project);
    }

    @Override
    public void addAll(Collection<Project> projects) {
        projectJpaRepository.saveAll(projects);
    }

    @Override
    public void remove(Project project) {
        projectJpaRepository.delete(project);
    }

    @Override
    public void removeAll(Collection<Project> projects) {
        projectJpaRepository.deleteAll(projects);
    }
}
