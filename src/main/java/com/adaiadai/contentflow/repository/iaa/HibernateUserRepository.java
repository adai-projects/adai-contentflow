package com.adaiadai.contentflow.repository.iaa;

import com.adaiadai.contentflow.domain.model.iaa.User;
import com.adaiadai.contentflow.domain.model.iaa.UserId;
import com.adaiadai.contentflow.domain.model.iaa.UserRepository;
import com.adaiadai.contentflow.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author adai
 */
@Component
public class HibernateUserRepository implements UserRepository {

    private final static String USER_ID_PREFIX = "iaa-user-";

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    public UserId nextIdentiy() {
        return new UserId(USER_ID_PREFIX + UUIDUtil.getUuidPartOne());
    }

    @Override
    public User userOfUserId(UserId userId) {
        return userJpaRepository.findByUserId(userId);
    }

    @Override
    public User userOfUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }

    @Override
    public void add(User user) {
        userJpaRepository.save(user);
    }
}
