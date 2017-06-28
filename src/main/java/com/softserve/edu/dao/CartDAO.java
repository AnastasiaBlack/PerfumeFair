package com.softserve.edu.dao;

import com.softserve.edu.entity.Cart;

public interface CartDAO extends ElementDAO<Cart> {
    Cart getCartByUserName(String name);
}
