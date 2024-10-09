package com.adaiadai.contentflow.repository.iaa;

import com.adaiadai.contentflow.domain.model.iaa.User;
import com.adaiadai.contentflow.domain.model.iaa.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRepository: 用户仓库
 *
 * @author adai
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUserId(UserId userId);

    List<User> findAllByUsernameContaining(String username);
}
