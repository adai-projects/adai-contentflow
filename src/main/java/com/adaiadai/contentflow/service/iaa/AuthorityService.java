package com.adaiadai.contentflow.service.iaa;

import com.adaiadai.contentflow.domain.model.iaa.Authority;
import com.adaiadai.contentflow.repository.iaa.AuthorityRepository;
import org.springframework.stereotype.Service;

/**
 * AuthorityService: 权限接口
 *
 * @author adai
 */
@Service
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority findById(Long id) {
        return authorityRepository.findById(id).orElse(null);
    }
}
