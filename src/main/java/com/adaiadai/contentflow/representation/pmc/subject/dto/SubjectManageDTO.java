package com.adaiadai.contentflow.representation.pmc.subject.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.subject.SubjectBase;

/**
 * SubjectManageDTO: 专题管理[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SubjectManageDTO extends SubjectBaseDTO {
    private static final long serialVersionUID = 1L;

    public SubjectManageDTO(SubjectBase subjectBase) {
        super(subjectBase);
    }

    public SubjectManageDTO() {
    }
}
