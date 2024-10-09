package com.adaiadai.contentflow.domain.model.pmc.project.version;

import com.adaiadai.contentflow.domain.model.pmc.project.ProjectId;

import java.util.Collection;

/**
 * @author adai
 */
public interface VersionRepository {

    VersionId nextIdentity();

    Version versionOfVersionId(VersionId versionId);

    Version versionOfProjectIdAndName(ProjectId projectId, String name);

    Collection<Version> versionsOfProjectId(ProjectId projectId);

    void add(Version version);

    void remove(Version version);

    void removeAll(Collection<Version> versions);
}
