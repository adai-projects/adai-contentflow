package com.adaiadai.contentflow.representation.sis.tag.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.sis.tag.TagBase;

/**
 * TagBaseVO: 标签基本视图对象
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagBaseVO extends TagBase {

    public TagBaseVO(TagBase tagBase) {
        super(tagBase);
    }

    public TagBaseVO() {

    }
}
