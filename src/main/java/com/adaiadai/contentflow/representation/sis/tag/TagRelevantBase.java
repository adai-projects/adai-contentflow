package com.adaiadai.contentflow.representation.sis.tag;

import lombok.Data;

/**
 * @author adai
 */
@Data
public class TagRelevantBase {

    private String tagName;
    private Integer counter;

    public TagRelevantBase(String tagName, Integer counter) {
        this.tagName = tagName;
        this.counter = counter;
    }

    public TagRelevantBase(TagRelevantBase tagRelevantBase) {
        this.tagName = tagRelevantBase.getTagName();
        this.counter = tagRelevantBase.getCounter();
    }

    public TagRelevantBase() {
    }
}
