package com.softserve.edu.dao;

import com.softserve.edu.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAO extends ElementDAOImpl<User> {
    public UserDAO() {
        super(User.class);
    }
}
