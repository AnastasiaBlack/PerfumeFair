package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ElementDAO;
import com.softserve.edu.dao.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


public class ElementDAOImpl<E> implements ElementDAO<E> {
    private Class<E> elementClass;

    private SessionFactory sessionFactory;

    public ElementDAOImpl(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    @Transactional
    @Override
    public void addElement(E element) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(element);
        transaction.commit();
        //This should have worked with the annotation @transactional and @autowired
        // sessionFactory.getCurrentSession().save(element);
    }

    @Transactional
    @Override
    public void updateElement(E element) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(element);
        transaction.commit();
        // sessionFactory.getCurrentSession().update(element);

    }

    @Transactional
    @Override
    public List<E> getAllElements() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
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


    @Transactional
    @Override
    public E getElementById(int elementId) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        E element = session.get(elementClass, elementId);
        transaction.commit();
        // E element = sessionFactory.getCurrentSession().get(elementClass, elementId);
        return element;
    }

    @Transactional
    @Override
    public void deleteElement(E element) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(element);
        transaction.commit();
        // sessionFactory.getCurrentSession().delete(element);
    }


}
