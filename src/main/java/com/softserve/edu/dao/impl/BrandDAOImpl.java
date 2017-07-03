package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.BrandDAO;
import com.softserve.edu.entity.Brand;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDAOImpl extends ElementDAOImpl<Brand> implements BrandDAO {
    private SessionFactory sessionFactory;
    @Autowired
    public BrandDAOImpl(SessionFactory sessionFactory) {
        super(Brand.class);
        this.sessionFactory=sessionFactory;
    }

}
