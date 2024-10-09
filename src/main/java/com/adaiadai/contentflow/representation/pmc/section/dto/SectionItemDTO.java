package com.adaiadai.contentflow.representation.pmc.section.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.section.SectionBase;

/**
 * SectionItemDTO: 类型条目[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SectionItemDTO extends SectionBaseDTO {
    private static final long serialVersionUID = 1L;

    public SectionItemDTO(SectionBase sectionBase) {
        super(sectionBase);
    }

    public SectionItemDTO() {
    }
}
