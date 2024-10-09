package com.adaiadai.contentflow.representation.iaa.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.iaa.UserBase;

/**
 * UserBaseVO: 用户基础[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserBaseVO extends UserBase {

    public UserBaseVO(UserBase userBase) {
        super(userBase);
    }

    public UserBaseVO() {
    }
}
