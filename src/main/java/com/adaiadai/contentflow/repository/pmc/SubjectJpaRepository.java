package com.adaiadai.contentflow.repository.pmc;

import com.adaiadai.contentflow.domain.model.pmc.project.subject.Subject;
import com.adaiadai.contentflow.domain.model.pmc.project.subject.SubjectId;
import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SubjectRepository: 主题仓库
 *
 * @author adai
 */
@Repository
public interface SubjectJpaRepository extends JpaRepository<Subject, Long> {

    Subject findBySubjectId(SubjectId subjectId);

    Subject findByVersionIdAndName(VersionId versionId, String name);

    List<Subject> findAllByVersionId(VersionId versionId);
}
