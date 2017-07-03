package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ElementDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public abstract class ElementDAOImpl<E> implements ElementDAO<E> {
    private Class<E> elementClass;

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    public ElementDAOImpl(Class<E> elementClass,SessionFactory sessionFactory) {
        this.elementClass = elementClass;
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addElement(E element) {
        sessionFactory.getCurrentSession().save(element);
    }

    @Override
    @Transactional
    public void updateElement(E element) {
        sessionFactory.getCurrentSession().update(element);

    }

    @Override
    @Transactional
    public List<E> getAllElements() {
        Session session = sessionFactory.getCurrentSession();
        List<E> allElements = new ArrayList<E>();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(elementClass);
        Root<E> root = cq.from(elementClass);
        cq.select(root);
        Query<E> q = session.createQuery(cq);
        allElements = q.getResultList();
        return allElements;
    }


    @Override
    @Transactional
    public E getElementById(int elementId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(elementClass, elementId);
    }

    @Override
    @Transactional
    public void deleteElement(E element) {
        sessionFactory.getCurrentSession().delete(element);
    }


}
