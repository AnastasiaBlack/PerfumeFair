package com.softserve.edu.dao;

import com.softserve.edu.entity.Cart;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CartDAO extends ElementDAOImpl<Cart> {

    public CartDAO() {
        super(Cart.class);
    }


}
