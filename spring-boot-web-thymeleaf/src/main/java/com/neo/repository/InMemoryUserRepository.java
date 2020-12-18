package com.neo.repository;

import com.neo.model.Message;
import com.neo.model.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryUserRepository implements UserRepository{

    private final ConcurrentMap<String, User> users = new ConcurrentHashMap<>();
    @Override
    public Iterable<User> findAll() {
        return this.users.values();
    }

    @Override
    public User save(User user) {
        this.users.put(user.getUserName(), user);
        return user;
    }

    @Override
    public User findUser(String userName) {
        return users.get(userName);
    }

    @Override
    public void deleteUser(String userName) {
        users.remove(userName);
    }
}
