package com.softserve.edu.dao;

import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.User;
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
public class UserDAO extends ElementDAOImpl<User> {
    public UserDAO() {
        super(User.class);
    }

    public User getUserByUserName(String userName) {
        User user;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User user where user.userName=:userName");
        query.setParameter("userName", userName);
        user = (User) query.getResultList().get(0);
        transaction.commit();
        return user;
    }
}
