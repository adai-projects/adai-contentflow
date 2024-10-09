package com.adaiadai.contentflow.representation.sis.tag.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.sis.tag.TagRelevantBase;

/**
 * TagRelevantDTO: 标签关联[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagRelevantDTO extends TagRelevantBase {
    private static final long serialVersionUID = 1L;

    public TagRelevantDTO(TagRelevantBase tagRelevantBase) {
        super(tagRelevantBase);
    }

    public TagRelevantDTO() {
    }
}
