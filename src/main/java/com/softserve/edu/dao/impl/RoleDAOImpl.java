package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.RoleDAO;
import com.softserve.edu.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends ElementDAOImpl<Role> implements RoleDAO {
    public RoleDAOImpl() {
        super(Role.class);
    }
}
