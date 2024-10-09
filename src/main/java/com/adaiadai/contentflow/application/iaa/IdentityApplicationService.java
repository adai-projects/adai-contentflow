package com.adaiadai.contentflow.application.iaa;

import com.adaiadai.contentflow.service.iaa.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author adai
 */
@Service
public class IdentityApplicationService {

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * 身份标识
     *
     * @return 标识
     */
    public String identity() {
        return authenticationService.identity();
    }
}
