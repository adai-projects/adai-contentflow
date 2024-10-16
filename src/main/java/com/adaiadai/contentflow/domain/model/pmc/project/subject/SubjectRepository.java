package com.adaiadai.contentflow.domain.model.pmc.project.subject;

import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;

import java.util.Collection;

/**
 * @author adai
 */
public interface SubjectRepository {

    SubjectId nextIdentity();

    Subject subjectOfSubjectId(SubjectId subjectId);

    Subject subjectOfVersionIdAndName(VersionId versionId, String name);

    Collection<Subject> subjectsOfVersionId(VersionId versionId);

    void add(Subject subject);

    void addAll(Collection<Subject> subjects);

    void remove(Subject subject);

    void removeAll(Collection<Subject> subjects);
}
