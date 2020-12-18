package com.neo.repository;

import com.neo.model.User;

public interface UserRepository {

    Iterable<User> findAll();

    User save(User user);

    User findUser(String userName);

    void deleteUser(String userName);

}
