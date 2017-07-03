package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.RoleDAO;
import com.softserve.edu.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDAOImpl extends ElementDAOImpl<Role> implements RoleDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public RoleDAOImpl(SessionFactory sessionFactory) {
        super(Role.class);
        this.sessionFactory=sessionFactory;
    }}
