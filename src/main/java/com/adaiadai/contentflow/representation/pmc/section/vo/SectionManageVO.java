package com.adaiadai.contentflow.representation.pmc.section.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.section.SectionBase;

/**
 * SectionManageVO: 类型管理[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SectionManageVO extends SectionBaseVO {

    public SectionManageVO(SectionBase sectionBase) {
        super(sectionBase);
    }

    public SectionManageVO() {
    }

}
