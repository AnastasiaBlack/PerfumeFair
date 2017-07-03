package com.softserve.edu.service.impl;

import com.softserve.edu.dao.CartDAO;
import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.User;
import com.softserve.edu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartDAO cartDAO;

    @Autowired
    public void setCartDAO(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    @Override
    @Transactional
    public void addCart(Cart cart) {
        cartDAO.addElement(cart);
    }

    @Override
    @Transactional
    public void updateCart(Cart cart) {
        cartDAO.updateElement(cart);
    }

    @Override
    @Transactional
    public Cart getCartById(int id) {
        return cartDAO.getElementById(id);
    }

    @Override
    @Transactional
    public void deleteCart(Cart cart) {
        cartDAO.deleteElement(cart);
    }

    @Override
    @Transactional
    public List<Cart> getAllCarts() {
        return cartDAO.getAllElements();
    }

    @Override
    @Transactional
    public Cart getCartByUser(User user) {
        return cartDAO.getCartByUserName(user.getUsername());
    }
}
