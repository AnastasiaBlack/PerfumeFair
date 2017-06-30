package com.softserve.edu.dao;

import com.softserve.edu.entity.User;
import org.springframework.stereotype.Repository;

public interface UserDAO extends ElementDAO<User> {
    User getUserByUserName(String username);
}
