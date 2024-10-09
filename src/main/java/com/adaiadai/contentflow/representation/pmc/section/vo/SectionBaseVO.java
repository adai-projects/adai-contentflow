package com.adaiadai.contentflow.representation.pmc.section.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.section.SectionBase;

/**
 * SectionBaseVO: 类型基础[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SectionBaseVO extends SectionBase {

    public SectionBaseVO(SectionBase sectionBase) {
        super(sectionBase);
    }

    public SectionBaseVO() {
    }
}
