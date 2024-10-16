package com.adaiadai.contentflow.application.pmc;

import com.adaiadai.contentflow.domain.model.pmc.project.subject.Subject;
import com.adaiadai.contentflow.domain.model.pmc.project.subject.SubjectId;
import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;
import com.adaiadai.contentflow.exception.MxException;
import com.adaiadai.contentflow.representation.pmc.subject.form.SubjectCreateForm;
import com.adaiadai.contentflow.representation.pmc.subject.form.SubjectModifyForm;
import com.adaiadai.contentflow.representation.pmc.subject.vo.SubjectBaseVO;
import com.adaiadai.contentflow.representation.pmc.subject.vo.SubjectItemVO;
import com.adaiadai.contentflow.representation.pmc.subject.vo.SubjectManageVO;
import com.adaiadai.contentflow.service.pmc.project.SubjectService;
import com.adaiadai.contentflow.service.pmc.translator.SubjectTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service
public class SubjectApplicationService {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectTranslator subjectTranslator;

    @Autowired
    private AxisApplicationService axisApplicationService;

    public SubjectModifyForm getModifyFormBySubjectId(String subjectId) {
        Subject subject = subjectService.getBySubjectId(new SubjectId(subjectId));
        if (subject != null) {
            return subjectTranslator.convertToModifyVo(subject);
        } else {
            return null;
        }
    }

    public List<SubjectItemVO> listItemVoByVersionId(String versionId) {
        List<Subject> subjects = subjectService.listByVersionId(new VersionId(versionId));
        if (subjects != null && subjects.size() > 0) {
            return subjectTranslator.convertToItemVo(subjects);
        } else {
            return null;
        }
    }

    public List<SubjectManageVO> listManageVoByVersionId(String versionId) {
        List<Subject> subjectList = subjectService.listByVersionId(new VersionId(versionId));
        if (subjectList != null && subjectList.size() > 0) {
            return subjectTranslator.convertToManageVo(subjectList);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public Subject post(SubjectCreateForm subjectCreateForm) {
        Subject byVersionIdAndName = subjectService.getByVersionIdAndName(new VersionId(subjectCreateForm.getVersionId()), subjectCreateForm.getName());
        if (byVersionIdAndName != null) {
            throw new MxException("专题已创建！");
        }
        SubjectId subjectId = subjectService.nextIdentity();
        Subject subject = new Subject(subjectId, subjectCreateForm.getName());
        subject.setDescription(subjectCreateForm.getDescription());
        // 专题允许单独存在，如果版本ID不为空，则绑定
        String versionId = subjectCreateForm.getVersionId();
        if (!"".equals(versionId)) {
            // TODO Exception handle
            subject.setVersionId(new VersionId(versionId));
            subject.setRank(subjectService.listByVersionId(new VersionId(versionId)).size() + 1);
        }
        subjectService.save(subject);
        return subjectService.getBySubjectId(subjectId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public SubjectBaseVO putBySubjectId(String subjectId, SubjectModifyForm subjectModifyForm) {
        Subject bySubjectId = subjectService.getBySubjectId(new SubjectId(subjectId));
        // 可修改的专题字段：名称及其描述。参考 SubjectModifyForm
        // 校验修改内容的名称，如果涉及内容包含名称，则需要判断新的名称是否存在
        if (!bySubjectId.name().equals(subjectModifyForm.getName())) {
            Subject byVersionIdAndName = subjectService.getByVersionIdAndName(bySubjectId.versionId()
                    , subjectModifyForm.getName());
            if (byVersionIdAndName != null) {
                // TODO Exception handle
                throw new MxException("专题已存在！");
            }
        }
        bySubjectId.setName(subjectModifyForm.getName());
        bySubjectId.setDescription(subjectModifyForm.getDescription());
        subjectService.update(bySubjectId);
        return subjectTranslator.convertToBaseVo(bySubjectId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteBySubjectId(String subjectId) {
        Subject bySubjectId = subjectService.getBySubjectId(new SubjectId(subjectId));
        if (bySubjectId == null) {
            // TODO Exception handle
            throw new MxException("专题已删除！");
        }
        // 关联坐标
        axisApplicationService.deleteAllBySubjectId(subjectId);
        subjectService.delete(bySubjectId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteAllByVersionId(String versionId) {
        // 关联专题
        List<Subject> subjectList = subjectService.listByVersionId(new VersionId(versionId));
        // 关联坐标
        List<String> subjectIds = new ArrayList<>(subjectList.size());
        subjectList.forEach(subject -> subjectIds.add(subject.subjectId().id()));
        axisApplicationService.deleteAllBySubjectIds(subjectIds);
        subjectService.deleteAll(subjectList);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteAllByVersionIds(List<String> versionIds) {
        // 关联专题
        List<Subject> subjectList = new ArrayList<>(versionIds.size());
        for (String versionId : versionIds) {
            subjectList.addAll(subjectService.listByVersionId(new VersionId(versionId)));
        }
        // 关联坐标
        List<String> subjectIds = new ArrayList<>(subjectList.size());
        subjectList.forEach(subject -> subjectIds.add(subject.subjectId().id()));
        axisApplicationService.deleteAllBySubjectIds(subjectIds);
        subjectService.deleteAll(subjectList);
    }

}
