package com.softserve.edu.service;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Sale;

import java.util.List;

public interface SaleService {
    void addSale(Sale sale);

    void updateSale(Sale sale);

    Sale getSaleById(int id);

    void deleteSale(Sale sale);

    List<Sale> getAllSales();

    List<Sale> getAllSalesFromCart(Cart cart);

}
