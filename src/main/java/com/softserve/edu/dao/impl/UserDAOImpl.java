package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.HibernateUtils;
import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl extends ElementDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = new User();
        Session session = HibernateUtils.getSessionFactory()
                .getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from User user where user" +
                ".username=:userName");
        query.setParameter("userName", userName);
        List<User> userListResult = query.getResultList();
        if (userListResult.size() != 0) {
            user = (User) userListResult.get(0);
            transaction.commit();
            return user;
        }

        transaction.commit();
        return user;
    }
}
