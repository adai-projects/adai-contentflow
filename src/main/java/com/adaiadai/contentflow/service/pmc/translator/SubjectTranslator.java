package com.adaiadai.contentflow.service.pmc.translator;

import com.adaiadai.contentflow.domain.model.pmc.project.subject.Subject;
import com.adaiadai.contentflow.representation.pmc.subject.SubjectBase;
import com.adaiadai.contentflow.representation.pmc.subject.form.SubjectModifyForm;
import com.adaiadai.contentflow.representation.pmc.subject.vo.SubjectBaseVO;
import com.adaiadai.contentflow.representation.pmc.subject.vo.SubjectItemVO;
import com.adaiadai.contentflow.representation.pmc.subject.vo.SubjectManageVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service
public class SubjectTranslator {

    private SubjectBase convertToBase(Subject subject) {
        SubjectBase subjectBase = new SubjectBase();
        subjectBase.setSubjectId(subject.subjectId().id());
        subjectBase.setVersionId(subject.versionId().id());
        subjectBase.setName(subject.name());
        subjectBase.setDescription(subject.description());
        subjectBase.setRank(subject.rank());
        return subjectBase;
    }

    public SubjectBaseVO convertToBaseVo(Subject subject) {
        return new SubjectBaseVO(convertToBase(subject));
    }

    public List<SubjectItemVO> convertToItemVo(List<Subject> subjects) {
        List<SubjectItemVO> subjectItemVos = new ArrayList<>(subjects.size());
        subjects.forEach(subject -> subjectItemVos.add(new SubjectItemVO(convertToBase(subject))));
        return subjectItemVos;
    }

    public List<SubjectManageVO> convertToManageVo(List<Subject> subjects) {
        List<SubjectManageVO> subjectManageVos = new ArrayList<>(subjects.size());
        subjects.forEach(subject -> subjectManageVos.add(new SubjectManageVO(convertToBase(subject))));
        return subjectManageVos;
    }

    public SubjectModifyForm convertToModifyVo(Subject subject) {
        return new SubjectModifyForm(subject.name(), subject.description());
    }

}
