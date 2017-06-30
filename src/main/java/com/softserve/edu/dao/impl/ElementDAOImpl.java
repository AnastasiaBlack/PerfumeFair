package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ElementDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class ElementDAOImpl<E> implements ElementDAO<E> {
    private Class<E> elementClass;

    private SessionFactory sessionFactory;


    public ElementDAOImpl(Class<E> elementClass,SessionFactory sessionFactory) {
        this.elementClass = elementClass;
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void addElement(E element) {
//        Session session = HibernateUtils.getSessionFactory()
// .getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(element);
//        transaction.commit();
        sessionFactory.getCurrentSession().save(element);
    }

    @Transactional
    @Override
    public void updateElement(E element) {
//        Session session = HibernateUtils.getSessionFactory()
// .getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        session.update(element);
//        transaction.commit();
        sessionFactory.getCurrentSession().update(element);

    }

    @Override
    @Transactional
    public List<E> getAllElements() {
        Session session = sessionFactory.getCurrentSession();
//        Session session = HibernateUtils.getSessionFactory()
// .getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<E> allElements = new ArrayList<E>();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(elementClass);
        Root<E> root = cq.from(elementClass);
        cq.select(root);
        Query<E> q = session.createQuery(cq);
        allElements = q.getResultList();
        transaction.commit();
        return allElements;
    }


    @Override
    @Transactional
    public E getElementById(int elementId) {
//        Session session = HibernateUtils.getSessionFactory()
// .getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        E element = session.get(elementClass, elementId);
//        transaction.commit();
//        return element;

        return sessionFactory.getCurrentSession().get(elementClass, elementId);
    }

    @Transactional
    @Override
    public void deleteElement(E element) {
//        Session session = HibernateUtils.getSessionFactory()
//                .getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(element);
//        transaction.commit();
        sessionFactory.getCurrentSession().delete(element);
    }


}
