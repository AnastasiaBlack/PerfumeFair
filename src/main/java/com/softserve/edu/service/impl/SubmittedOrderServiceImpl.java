package com.softserve.edu.service.impl;

import com.softserve.edu.dao.SubmittedOrderDAO;
import com.softserve.edu.entity.SubmittedOrder;
import com.softserve.edu.service.SubmittedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubmittedOrderServiceImpl implements SubmittedOrderService {
    private SubmittedOrderDAO submittedOrderDAO;

    @Autowired
    public void setSubmittedOrderDAO(SubmittedOrderDAO submittedOrderDAO) {
        this.submittedOrderDAO = submittedOrderDAO;
    }


    @Transactional
    @Override
    public void addSubmittedOrder(SubmittedOrder submittedOrder) {
        submittedOrderDAO.addElement(submittedOrder);
//        DAOFactory.getInstance().getSubmittedOrderDAOImpl().addElement
//                (submittedOrder);
    }

    @Transactional
    @Override
    public void updateSubmittedOrder(SubmittedOrder submittedOrder) {
        submittedOrderDAO.updateElement(submittedOrder);
//        DAOFactory.getInstance().getSubmittedOrderDAOImpl().updateElement
//                (submittedOrder);
    }

    @Transactional
    @Override
    public SubmittedOrder getSubmittedOrderById(int id) {
        return submittedOrderDAO.getElementById(id);
//        return DAOFactory.getInstance().getSubmittedOrderDAOImpl()
// .getElementById(id);
    }

    @Transactional
    @Override
    public void deleteSubmittedOrder(SubmittedOrder submittedOrder) {
        submittedOrderDAO.deleteElement(submittedOrder);
//        DAOFactory.getInstance().getSubmittedOrderDAOImpl().deleteElement
// (submittedOrder);
    }

    @Transactional
    @Override
    public List<SubmittedOrder> getAllSubmittedOrders() {
        return submittedOrderDAO.getAllElements();
//        return DAOFactory.getInstance().getSubmittedOrderDAOImpl()
// .getAllElements();
    }

    @Override
    public List<SubmittedOrder> getSubmittedOrdersByUserName(String userName) {
        return submittedOrderDAO.getSubmittedOrdersByUserName(userName);
    }
}
