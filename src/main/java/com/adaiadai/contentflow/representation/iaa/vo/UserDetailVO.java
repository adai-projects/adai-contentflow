package com.adaiadai.contentflow.representation.iaa.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.iaa.UserBase;

/**
 * UserDetailVO: 用户详情[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDetailVO extends UserBaseVO {

    private Boolean owned;

    public UserDetailVO(UserBase userBase) {
        super(userBase);
    }

    public UserDetailVO() {
    }
}
