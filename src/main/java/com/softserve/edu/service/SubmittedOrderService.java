package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.entity.SubmittedOrder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubmittedOrderService {
    @Transactional
    public void addSubmittedOrder(SubmittedOrder submittedOrder) {
        DAOFactory.getInstance().getSubmittedOrderDAO().addElement
                (submittedOrder);
    }

    @Transactional
    public void updateSubmittedOrder(SubmittedOrder submittedOrder) {
        DAOFactory.getInstance().getSubmittedOrderDAO().updateElement
                (submittedOrder);
    }

    @Transactional
    public SubmittedOrder getSubmittedOrderById(int id) {
        return DAOFactory.getInstance().getSubmittedOrderDAO().getElementById(id);
    }

    @Transactional
    public void deleteSubmittedOrder (SubmittedOrder submittedOrder) {
        DAOFactory.getInstance().getSubmittedOrderDAO().deleteElement(submittedOrder);
    }

    @Transactional
    public List<SubmittedOrder> getAllSubmittedOrders() {
        return DAOFactory.getInstance().getSubmittedOrderDAO().getAllElements();
    }
}
