package com.adaiadai.contentflow.representation.iaa.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.iaa.UserBase;

/**
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserCardDTO extends UserBaseDTO {
    private static final long serialVersionUID = 1L;

    public UserCardDTO(UserBase userBase) {
        super(userBase);
    }
}
