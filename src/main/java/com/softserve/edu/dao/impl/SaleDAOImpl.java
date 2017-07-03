package com.softserve.edu.dao.impl;


import com.softserve.edu.dao.SaleDAO;
import com.softserve.edu.entity.Sale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleDAOImpl extends ElementDAOImpl<Sale> implements SaleDAO {
    private SessionFactory sessionFactory;
    public SaleDAOImpl(SessionFactory sessionFactory) {
        super(Sale.class, sessionFactory);
        this.sessionFactory=sessionFactory;
    }
    @Override
    @Transactional
    public List<Sale> getAllSalesFromCart(int cartId) {
        List<Sale> salesInCart = new ArrayList<Sale>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Sale sale where sale.cart.id=:cartId");
        query.setParameter("cartId", cartId);
        salesInCart = query.getResultList();
        return salesInCart;
    }

}
