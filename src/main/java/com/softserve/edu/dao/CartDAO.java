package com.softserve.edu.dao;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CartDAO extends ElementDAOImpl<Cart> {

    public CartDAO() {
        super(Cart.class);
    }

    public Cart getCartByUserName(String userName) {
        Cart cart = new Cart();
        Session session = HibernateUtils.getSessionFactory()
                .getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Cart cart where cart.user.username=:userName");
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
