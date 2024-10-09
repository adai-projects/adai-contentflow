package com.adaiadai.contentflow.service.iaa;

import com.adaiadai.contentflow.constant.iaa.UserExceptionEnum;
import com.adaiadai.contentflow.domain.model.iaa.User;
import com.adaiadai.contentflow.exception.UserException;
import com.adaiadai.contentflow.util.SecurityUtil;
import org.springframework.stereotype.Service;

/**
 * @author adai
 */
@Service
public class AuthenticationService {

    public String identity() {
        User user = SecurityUtil.getPrincipal();
        if (user != null) {
            return user.username();
        } else {
            throw new UserException(UserExceptionEnum.USER_ON_ABSENT);
        }
    }
}
