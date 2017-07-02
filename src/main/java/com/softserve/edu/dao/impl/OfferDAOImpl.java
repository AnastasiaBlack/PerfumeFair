package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.OfferDAO;
import com.softserve.edu.entity.Offer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfferDAOImpl extends ElementDAOImpl<Offer> implements OfferDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public OfferDAOImpl(SessionFactory sessionFactory) {
        super(Offer.class,sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Offer> getAllOffersByPerfumeFilter(String perfumeName) {
        Session session = sessionFactory.getCurrentSession();
//        Session session = HibernateUtils.getSessionFactory()
//                .getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        List<Offer> allElements = new ArrayList<>();
        Query query = session.createQuery("from Offer offer where offer" +
                ".perfume.name=:perfumeName");
        query.setParameter("perfumeName", perfumeName);
        allElements = query.getResultList();
//        transaction.commit();
        return allElements;
    }

    @Transactional
    public List<Offer> getAllOffersByBrandFilter(String brandName) {
        Session session = sessionFactory.getCurrentSession();
//        Session session = HibernateUtils.getSessionFactory()
//                .getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        List<Offer> allElements = new ArrayList<>();
        Query query = session.createQuery("from Offer offer where offer" +
                ".perfume.brand.name=:brandName");
        query.setParameter("brandName", brandName);
        allElements = query.getResultList();
//        transaction.commit();
        return allElements;
    }

}
