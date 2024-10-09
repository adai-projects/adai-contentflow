package com.adaiadai.contentflow.representation.pmc.section.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.section.SectionBase;

import java.io.Serializable;

/**
 * TypeBaseDTO: 类型基础[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SectionBaseDTO extends SectionBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public SectionBaseDTO(SectionBase sectionBase) {
        super(sectionBase);
    }

    public SectionBaseDTO() {
    }

}
