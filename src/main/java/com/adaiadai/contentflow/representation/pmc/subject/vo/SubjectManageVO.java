package com.adaiadai.contentflow.representation.pmc.subject.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.subject.SubjectBase;

/**
 * SubjectManageVO: 专题管理[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SubjectManageVO extends SubjectBaseVO {

    public SubjectManageVO(SubjectBase subjectBase) {
        super(subjectBase);
    }

    public SubjectManageVO() {
    }
}
