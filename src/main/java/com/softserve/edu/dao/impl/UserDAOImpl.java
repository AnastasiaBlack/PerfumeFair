package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl extends ElementDAOImpl<User> implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User getUserByUserName(String userName) {
        User user = new User();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User user where user" +
                ".username=:userName");
        query.setParameter("userName", userName);
        List<User> userListResult = query.getResultList();
        if (userListResult.size() != 0) {
            user = (User) userListResult.get(0);
            return user;
        }
        return user;
    }
}
