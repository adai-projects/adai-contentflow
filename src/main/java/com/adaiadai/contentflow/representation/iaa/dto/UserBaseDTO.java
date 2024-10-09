package com.adaiadai.contentflow.representation.iaa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.iaa.UserBase;

/**
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserBaseDTO extends UserBase {
    private static final long serialVersionUID = 1L;

    public UserBaseDTO(UserBase userBase) {
        super(userBase);
    }
}
