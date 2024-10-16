package com.adaiadai.contentflow.repository.pmc;

import com.adaiadai.contentflow.domain.model.pmc.indentity.Creator;
import com.adaiadai.contentflow.domain.model.pmc.project.Project;
import com.adaiadai.contentflow.domain.model.pmc.project.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adai
 */
@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, Long> {

    Project findByProjectId(ProjectId projectId);

    Project findByCreatorAndName(Creator creator, String name);

    List<Project> findAllByProperty(Integer property);

    List<Project> findAllByPropertyAndScopeAndAboveProjectId(Integer property, Integer scope, String aboveProjectId);

    List<Project> findAllByPropertyAndAboveProjectId(Integer property, String aboveProjectId);

    List<Project> findAllByScope(Integer scope);

    List<Project> findAllByAboveProjectId(String aboveProjectId);

    List<Project> findAllByAboveProjectIdAndScope(String aboveProjectId, Integer scope);

    List<Project> findAllByCreator(Creator creator);

    List<Project> findAllByCreatorAndScope(Creator creator, Integer scope);

}
