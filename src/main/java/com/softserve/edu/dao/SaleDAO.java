package com.softserve.edu.dao;


import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Sale;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SaleDAO extends ElementDAOImpl<Sale> {
    public SaleDAO() {
        super(Sale.class);
    }

    public List<Sale> getAllSalesFromCart(int cartId) {
        List<Sale> salesInCart = new ArrayList<Sale>();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Sale sale where sale.cart.id=:cartId");
        query.setParameter("cartId", cartId);
        salesInCart = query.getResultList();
        transaction.commit();

        return salesInCart;
    }
}
