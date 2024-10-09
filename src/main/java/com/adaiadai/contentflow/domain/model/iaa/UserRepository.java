package com.adaiadai.contentflow.domain.model.iaa;

/**
 * @author adai
 */
public interface UserRepository {

    UserId nextIdentiy();

    User userOfUserId(UserId userId);

    User userOfUsername(String username);

    void add(User user);
}
