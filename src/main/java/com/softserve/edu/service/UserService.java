package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.dao.RoleDAO;
import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.Role;
import com.softserve.edu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Transactional
    public void addUser(User user) {
        DAOFactory.getInstance().getUserDAO().addElement(user);
    }

    @Transactional
    public void updateUser(User user) {
        DAOFactory.getInstance().getUserDAO().updateElement(user);
    }

    @Transactional
    public User getUserById(int id) {
        User user = DAOFactory.getInstance().getUserDAO().getElementById(id);
        return user;
    }

    @Transactional
    public void deleteUser(User user) {
        DAOFactory.getInstance().getUserDAO().deleteElement(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        return DAOFactory.getInstance().getUserDAO().getAllElements();
    }

    @Autowired
    private UserDAO userDao;

    @Autowired
    private RoleDAO roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getElementById(1));
        user.setRoles(roles);
        addUser(user);
    }

    public User findByUsername(String username) {
        return userDao.getUserByUserName(username);
    }

}
