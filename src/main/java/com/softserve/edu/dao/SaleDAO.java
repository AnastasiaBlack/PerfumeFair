package com.softserve.edu.dao;

import com.softserve.edu.entity.Sale;

import java.util.List;

public interface SaleDAO extends ElementDAO<Sale> {
    List<Sale> getAllSalesFromCart(int cartId);
}
