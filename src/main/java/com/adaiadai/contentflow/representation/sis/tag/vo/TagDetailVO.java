package com.adaiadai.contentflow.representation.sis.tag.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.sis.tag.TagBase;

import java.util.List;

/**
 * TagDetailVO: 标签详情[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagDetailVO extends TagBaseVO {
    private List<TagRelevantVO> tagRelevantVoList;

    public TagDetailVO(TagBase tagBase) {
        super(tagBase);
    }

    public TagDetailVO() {
    }
}
