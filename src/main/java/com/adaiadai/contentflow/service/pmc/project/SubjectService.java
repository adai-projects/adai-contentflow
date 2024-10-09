package com.adaiadai.contentflow.service.pmc.project;

import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;
import com.adaiadai.contentflow.domain.model.pmc.project.subject.Subject;
import com.adaiadai.contentflow.domain.model.pmc.project.subject.SubjectId;
import com.adaiadai.contentflow.domain.model.pmc.project.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SubjectService: 专题服务
 *
 * @author adai
 */
@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectId nextIdentity() {
        return subjectRepository.nextIdentity();
    }

    public Subject getBySubjectId(SubjectId subjectId) {
        return subjectRepository.subjectOfSubjectId(subjectId);
    }

    public Subject getByVersionIdAndName(VersionId versionId, String name) {
        return subjectRepository.subjectOfVersionIdAndName(versionId, name);
    }

    public List<Subject> listByVersionId(VersionId versionId) {
        return (List<Subject>) subjectRepository.subjectsOfVersionId(versionId);
    }

    public void save(Subject subject) {
        subjectRepository.add(subject);
    }

    public void update(Subject subject) {
        subjectRepository.add(subject);
    }

    public void delete(Subject subject) {
        subjectRepository.remove(subject);
    }

    public void deleteAll(List<Subject> subjectList) {
        subjectRepository.removeAll(subjectList);
    }

}
