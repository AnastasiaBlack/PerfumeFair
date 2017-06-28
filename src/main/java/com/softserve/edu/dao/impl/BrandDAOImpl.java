package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.BrandDAO;
import com.softserve.edu.entity.Brand;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDAOImpl extends ElementDAOImpl<Brand> implements BrandDAO {
    public BrandDAOImpl() {
        super(Brand.class);
    }


}
