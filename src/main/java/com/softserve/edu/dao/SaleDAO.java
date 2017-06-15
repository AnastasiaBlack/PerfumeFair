package com.softserve.edu.dao;


import com.softserve.edu.entity.Sale;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SaleDAO extends ElementDAOImpl<Sale> {
    public SaleDAO() {
        super(Sale.class);
    }
}
