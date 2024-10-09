package com.adaiadai.contentflow.representation.sis.tag.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.sis.tag.TagRelevantBase;

/**
 * TagRelevantVO: 标签关联[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagRelevantVO extends TagRelevantBase {


    public TagRelevantVO(TagRelevantBase tagRelevantBase) {
        super(tagRelevantBase);
    }

    public TagRelevantVO() {
    }
}
