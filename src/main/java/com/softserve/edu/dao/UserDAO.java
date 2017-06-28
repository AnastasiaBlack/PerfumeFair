package com.softserve.edu.dao;

import com.softserve.edu.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAO extends ElementDAOImpl<User> {
    public UserDAO() {
        super(User.class);
    }

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
