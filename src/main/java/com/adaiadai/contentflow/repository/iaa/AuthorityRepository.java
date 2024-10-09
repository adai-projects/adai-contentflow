package com.adaiadai.contentflow.repository.iaa;

import com.adaiadai.contentflow.domain.model.iaa.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AuthorityRepository: 权限仓库
 *
 * @author adai
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
