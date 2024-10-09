package com.adaiadai.contentflow.representation.pmc.subject.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.subject.SubjectBase;

/**
 * SubjectItemVO: 专题条目[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SubjectItemVO extends SubjectBaseVO {

    public SubjectItemVO(SubjectBase subjectBase) {
        super(subjectBase);
    }

    public SubjectItemVO() {
    }
}
