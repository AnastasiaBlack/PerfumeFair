package com.softserve.edu.service;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.User;

import java.util.List;

public interface CartService {

    void addCart(Cart cart);

    void updateCart(Cart cart);

    Cart getCartById(int id);

    void deleteCart(Cart cart);

    List<Cart> getAllCarts();

    Cart getCartByUser(User user);
}
