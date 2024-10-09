package com.adaiadai.contentflow.representation.iaa.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.iaa.UserBase;

/**
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserCardVO extends UserBaseVO {

    public UserCardVO(UserBase userBase) {
        super(userBase);
    }

    public UserCardVO() {
    }
}
