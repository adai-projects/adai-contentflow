package com.adaiadai.contentflow.representation.pmc.subject;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author adai
 */
@Data
public class SubjectBase {

    private String subjectId;
    private String versionId;
    private String name;
    private String description;
    private Integer rank;

    public SubjectBase(SubjectBase subjectBase) {
        BeanUtils.copyProperties(subjectBase, this);
    }

    public SubjectBase() {
    }
}
