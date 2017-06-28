package com.softserve.edu.dao;


import com.softserve.edu.entity.Role;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class RoleDAO extends ElementDAOImpl<Role> {
    public RoleDAO() {
        super(Role.class);
    }
}
