package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.CartDAO;
import com.softserve.edu.dao.HibernateUtils;
import com.softserve.edu.entity.Cart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CartDAOImpl extends ElementDAOImpl<Cart> implements CartDAO {

    public CartDAOImpl() {
        super(Cart.class);
    }

    @Override
    public Cart getCartByUserName(String userName) {
        Cart cart = new Cart();
        Session session = HibernateUtils.getSessionFactory()
                .getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Cart cart where cart.user" +
                ".username=:userName");
        query.setParameter("userName", userName);
        List<Cart> cartListResult = query.getResultList();
        if (cartListResult.size() != 0) {
            cart = (Cart) cartListResult.get(0);
            transaction.commit();
            return cart;
        }
        return cart;
    }
}
