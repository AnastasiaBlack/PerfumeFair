package com.softserve.edu.service;

import com.softserve.edu.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    void deleteUser(User user);

    List<User> getAllUsers();

    void save(User user);

    User findByUsername(String username);
}
