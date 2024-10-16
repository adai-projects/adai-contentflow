package com.adaiadai.contentflow.exception;

import com.adaiadai.contentflow.constant.pmc.ProjectExceptionEnum;
import com.adaiadai.contentflow.controller.pmc.ProjectController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProjectException: 项目异常
 *
 * @author adai
 */
public class ProjectException extends MxException {
    private final static Logger logger = LoggerFactory.getLogger(ProjectController.class);

    private ProjectExceptionEnum projectExceptionEnum;

    public ProjectException(ProjectExceptionEnum projectExceptionEnum) {
        super(projectExceptionEnum.getCode(), projectExceptionEnum.getMessage());
    }

    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectException(Throwable cause) {
        super(cause);
    }

    protected ProjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProjectException(String code, String message) {
        super(code, message);
    }
}
