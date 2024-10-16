package com.adaiadai.contentflow.application.pmc;

import com.adaiadai.contentflow.domain.model.pmc.project.section.Section;
import com.adaiadai.contentflow.domain.model.pmc.project.section.SectionId;
import com.adaiadai.contentflow.domain.model.pmc.project.version.VersionId;
import com.adaiadai.contentflow.exception.MxException;
import com.adaiadai.contentflow.representation.pmc.section.form.SectionCreateForm;
import com.adaiadai.contentflow.representation.pmc.section.form.SectionModifyForm;
import com.adaiadai.contentflow.representation.pmc.section.vo.SectionBaseVO;
import com.adaiadai.contentflow.representation.pmc.section.vo.SectionItemVO;
import com.adaiadai.contentflow.representation.pmc.section.vo.SectionManageVO;
import com.adaiadai.contentflow.service.pmc.project.SectionService;
import com.adaiadai.contentflow.service.pmc.translator.SectionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service
public class SectionApplicationService {

    @Autowired
    private AxisApplicationService axisApplicationService;

    @Autowired
    private SectionService sectionService;
    @Autowired
    private SectionTranslator sectionTranslator;

    public SectionModifyForm getModifyFormBySectionId(String sectionId) {
        Section bySectionId = sectionService.getBySectionId(new SectionId(sectionId));
        if (sectionId != null) {
            return sectionTranslator.convertToModifyForm(bySectionId);
        } else {
            return null;
        }
    }

    public List<SectionItemVO> listItemVoByVersionId(String versionId) {
        List<Section> sectionList = sectionService.listByVersionId(new VersionId(versionId));
        if (!sectionList.isEmpty()) {
            return sectionTranslator.convertToItemVo(sectionList);
        } else {
            return null;
        }
    }

    public List<SectionManageVO> listManageVoByVersionId(String versionId) {
        List<Section> sectionList = sectionService.listByVersionId(new VersionId(versionId));
        if (sectionList != null && sectionList.size() > 0) {
            return sectionTranslator.convertToManageVo(sectionList);
        } else {
            return null;
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public Section post(SectionCreateForm sectionCreateForm) {
        Section byVersionIdAndName = sectionService.getByVersionIdAndName(new VersionId(sectionCreateForm.getVersionId())
                , sectionCreateForm.getName());
        if (byVersionIdAndName != null) {
            // TODO Exception Handle
            throw new MxException("类型已创建！");
        }
        SectionId sectionId = sectionService.nextIdentity();
        VersionId versionId = new VersionId(sectionCreateForm.getVersionId());
        Section section = new Section(sectionId, versionId, sectionCreateForm.getName());
        section.setRank(sectionService.listByVersionId(versionId).size() + 1);
        sectionService.save(section);
        return sectionService.getBySectionId(sectionId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public SectionBaseVO putBySectionId(String sectionId, SectionModifyForm sectionModifyForm) {
        Section bySectionId = sectionService.getBySectionId(new SectionId(sectionId));
        // 可修改的类型字段：名称及其描述。参考 SectionModifyForm
        // 校验修改内容的名称，如果涉及内容包含名称，则需要判断新的名称是否存在
        // 1. 修改描述
        if (!bySectionId.name().equals(sectionModifyForm.getName())) {
            Section byVersionIdAndName = sectionService.getByVersionIdAndName(bySectionId.versionId()
                    , sectionModifyForm.getName());
            if (byVersionIdAndName != null) {
                // TODO Exception Handle
                throw new MxException("类型已存在！");
            }
        }
        bySectionId.setName(sectionModifyForm.getName());
        bySectionId.setDescription(sectionModifyForm.getDescription());
        sectionService.update(bySectionId);
        return sectionTranslator.convertToBaseVo(bySectionId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteBySectionId(String sectionId) {
        Section bySectionId = sectionService.getBySectionId(new SectionId(sectionId));
        if (bySectionId == null) {
            throw new MxException("类型已删除！");
        }
        // 关联坐标
        axisApplicationService.deleteAllBySectionId(sectionId);
        sectionService.delete(bySectionId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteAllByVersionId(String versionId) {
        // 关联类型
        List<Section> sectionList = sectionService.listByVersionId(new VersionId(versionId));
        List<String> sectionIds = new ArrayList<>(sectionList.size());
        sectionList.forEach(section -> sectionIds.add(section.sectionId().id()));
        // 关联坐标
        axisApplicationService.deleteAllBySectionIds(sectionIds);
        sectionService.deleteAll(sectionList);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteAllByVersionIds(List<String> versionIds) {
        // 关联类型
        List<Section> sectionList = new ArrayList<>(versionIds.size());
        versionIds.forEach(versionId -> sectionList.addAll(sectionService.listByVersionId(new VersionId(versionId))));
        // 关联坐标
        List<String> sectionIds = new ArrayList<>(sectionList.size());
        sectionList.forEach(section -> sectionIds.add(section.sectionId().id()));
        axisApplicationService.deleteAllBySectionIds(sectionIds);
        sectionService.deleteAll(sectionList);
    }

}
