package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.RoleDAO;
import com.softserve.edu.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends ElementDAOImpl<Role> implements RoleDAO {
    private SessionFactory sessionFactory;
    public RoleDAOImpl(SessionFactory sessionFactory) {
        super(Role.class, sessionFactory);
        this.sessionFactory=sessionFactory;
    }}
