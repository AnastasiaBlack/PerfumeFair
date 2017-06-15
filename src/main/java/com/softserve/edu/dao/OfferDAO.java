package com.softserve.edu.dao;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.entity.Offer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class OfferDAO extends ElementDAOImpl<Offer> {

    public OfferDAO() {
        super(Offer.class);
    }

    @Transactional
    public List<Offer> getAllOffersByPerfumeFilter(String perfumeName) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Offer> allElements = new ArrayList<>();
        Query query = session.createQuery("from Offer offer where offer.perfume.name=:perfumeName");
        query.setParameter("perfumeName", perfumeName);
        allElements = query.getResultList();
        transaction.commit();
        return allElements;
    }

    @Transactional
    public List<Offer> getAllOffersByBrandFilter(String brandName) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Offer> allElements = new ArrayList<>();
        Query query = session.createQuery("from Offer offer where offer.perfume.brand.name=:brandName");
        query.setParameter("brandName", brandName);
        allElements = query.getResultList();
        transaction.commit();
        return allElements;
    }

}
