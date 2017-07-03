package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.CartDAO;
import com.softserve.edu.entity.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CartDAOImpl extends ElementDAOImpl<Cart> implements CartDAO {

    private SessionFactory sessionFactory;
    @Autowired
    public CartDAOImpl(SessionFactory sessionFactory) {
        super(Cart.class,sessionFactory);
        this.sessionFactory=sessionFactory;
    }

    @Override
    @Transactional
    public Cart getCartByUserName(String userName) {
        Cart cart = new Cart();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart cart where cart.user" +
                ".username=:userName");
        query.setParameter("userName", userName);
        List<Cart> cartListResult = query.getResultList();
        if (cartListResult.size() != 0) {
            cart = (Cart) cartListResult.get(0);
            return cart;
        }
        return cart;
    }
}
