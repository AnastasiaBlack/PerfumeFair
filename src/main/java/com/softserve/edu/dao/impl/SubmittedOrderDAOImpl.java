package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.HibernateUtils;
import com.softserve.edu.dao.SubmittedOrderDAO;
import com.softserve.edu.entity.SubmittedOrder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubmittedOrderDAOImpl extends ElementDAOImpl<SubmittedOrder>
        implements SubmittedOrderDAO {

    public SubmittedOrderDAOImpl() {
        super(SubmittedOrder.class);
    }

    @Override
    public List<SubmittedOrder> getSubmittedOrdersByUserName(String userName) {
        Session session = HibernateUtils.getSessionFactory()
                .getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<SubmittedOrder> allElements = new ArrayList<>();
        Query query = session.createQuery("from SubmittedOrder " +
                "submittedOrders where submittedOrders.user.username=:name");
        query.setParameter("name", userName);
        allElements = query.getResultList();
        transaction.commit();
        return allElements;
    }
}
