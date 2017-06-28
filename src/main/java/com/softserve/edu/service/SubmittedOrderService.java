package com.softserve.edu.service;

import com.softserve.edu.entity.SubmittedOrder;

import java.util.List;

public interface SubmittedOrderService {
    void addSubmittedOrder(SubmittedOrder submittedOrder);

    void updateSubmittedOrder(SubmittedOrder submittedOrder);

    SubmittedOrder getSubmittedOrderById(int id);

    void deleteSubmittedOrder(SubmittedOrder submittedOrder);

    List<SubmittedOrder> getAllSubmittedOrders();
    List<SubmittedOrder> getSubmittedOrdersByUserName(String userName);
}
