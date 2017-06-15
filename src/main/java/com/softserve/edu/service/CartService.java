package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.entity.Cart;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class CartService {
    @Transactional
    public void addCart(Cart cart) {
        DAOFactory.getInstance().getCartDAO().addElement(cart);
    }

    @Transactional
    public void updateCart(Cart cart) {
        DAOFactory.getInstance().getCartDAO().updateElement(cart);
    }

    @Transactional
    public Cart getCartById(int id) {
        Cart cart = DAOFactory.getInstance().getCartDAO().getElementById(id);
        return cart;
    }
    @Transactional
    public void deleteCart(Cart cart) {
        DAOFactory.getInstance().getCartDAO().deleteElement(cart);
    }

    @Transactional
    public List<Cart> getAllCarts() {
        return DAOFactory.getInstance().getCartDAO().getAllElements();
    }
}
