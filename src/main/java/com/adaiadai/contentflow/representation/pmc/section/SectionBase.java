package com.adaiadai.contentflow.representation.pmc.section;

import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author adai
 */
@Data
public class SectionBase {

    private String sectionId;
    private String name;
    private String description;
    private String versionId;
    private Integer rank;

    public SectionBase(SectionBase sectionBase) {
        BeanUtils.copyProperties(sectionBase, this);
    }

    public SectionBase() {
    }
}
