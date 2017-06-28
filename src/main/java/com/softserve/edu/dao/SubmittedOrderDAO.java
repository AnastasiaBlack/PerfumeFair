package com.softserve.edu.dao;

import com.softserve.edu.entity.SubmittedOrder;

import java.util.List;

public interface SubmittedOrderDAO extends ElementDAO<SubmittedOrder> {
    List<SubmittedOrder> getSubmittedOrdersByUserName(String userName);
}
