package com.adaiadai.contentflow.repository.pmc;

import com.adaiadai.contentflow.domain.model.pmc.project.ProjectId;
import com.adaiadai.contentflow.domain.model.pmc.project.version.Version;
import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * VersionRepository: 版本仓库
 *
 * @author adai
 */
@Repository
public interface VersionJpaRepository extends JpaRepository<Version, Long> {


    Version findByVersionId(VersionId versionId);

    Version findByProjectIdAndName(ProjectId projectId, String name);

    List<Version> findAllByProjectId(ProjectId projectId);

}
