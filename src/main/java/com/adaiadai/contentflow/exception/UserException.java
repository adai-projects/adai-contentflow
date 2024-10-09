package com.adaiadai.contentflow.exception;

import com.adaiadai.contentflow.constant.iaa.UserExceptionEnum;

/**
 * UserException: 用户异常
 *
 * @author adai
 */
public class UserException extends MxException {

    private UserExceptionEnum userExceptionEnum;

    public UserException(UserExceptionEnum userExceptionEnum) {
        super(userExceptionEnum.getCode(), userExceptionEnum.getMessage());
    }
    public UserExceptionEnum getUserExceptionEnum() {
        return userExceptionEnum;
    }

    public void setUserExceptionEnum(UserExceptionEnum userExceptionEnum) {
        this.userExceptionEnum = userExceptionEnum;
    }
}
