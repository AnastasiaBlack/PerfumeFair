package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.HibernateUtils;
import com.softserve.edu.dao.SaleDAO;
import com.softserve.edu.entity.Sale;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleDAOImpl extends ElementDAOImpl<Sale> implements SaleDAO {
    public SaleDAOImpl() {
        super(Sale.class);
    }

    @Override
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