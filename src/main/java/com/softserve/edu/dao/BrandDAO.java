package com.softserve.edu.dao;

import com.softserve.edu.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class BrandDAO extends ElementDAOImpl<Brand> {
    @Autowired
    public BrandDAO() {
        super(Brand.class);
    }


}
