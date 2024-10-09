package com.adaiadai.contentflow.exception;

import com.adaiadai.contentflow.constant.sis.TagExceptionEnum;
import com.adaiadai.contentflow.controller.pmc.ProjectController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TagException: 标签异常
 *
 * @author adai
 */
public class TagException extends MxException {
    private final static Logger logger = LoggerFactory.getLogger(ProjectController.class);

    private TagExceptionEnum tagExceptionEnum;

    public TagException(TagExceptionEnum tagExceptionEnum) {
        super(tagExceptionEnum.getCode(), tagExceptionEnum.getMessage());
    }

    public TagException(String message) {
        super(message);
    }

    public TagExceptionEnum getTagExceptionEnum() {
        return tagExceptionEnum;
    }

    public void setTagExceptionEnum(TagExceptionEnum tagExceptionEnum) {
        this.tagExceptionEnum = tagExceptionEnum;
    }
}
