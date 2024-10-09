package com.adaiadai.contentflow.representation.pmc.section.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.section.SectionBase;

/**
 * SectionItemVO: 类型条目[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SectionItemVO extends SectionBaseVO {

    public SectionItemVO(SectionBase sectionBase) {
        super(sectionBase);
    }

    public SectionItemVO() {
    }

}
