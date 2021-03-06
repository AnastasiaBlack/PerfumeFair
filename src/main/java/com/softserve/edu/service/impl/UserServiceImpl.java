package com.softserve.edu.service.impl;

import com.softserve.edu.dao.RoleDAO;
import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import com.softserve.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserRoleDAOs(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addElement(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateElement(user);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return userDAO.getElementById(id);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDAO.deleteElement(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllElements();
    }


    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getElementById(1));
        user.setRoles(roles);
        addUser(user);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDAO.getUserByUserName(username);
    }

}
