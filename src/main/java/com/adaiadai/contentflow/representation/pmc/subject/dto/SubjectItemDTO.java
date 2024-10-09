package com.adaiadai.contentflow.representation.pmc.subject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.subject.SubjectBase;

/**
 * SubjectItemDTO: 专题条目[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SubjectItemDTO extends SubjectBaseDTO {
    private static final long serialVersionUID = 1L;

    public SubjectItemDTO(SubjectBase subjectBase) {
        super(subjectBase);
    }

    public SubjectItemDTO() {
    }
}
