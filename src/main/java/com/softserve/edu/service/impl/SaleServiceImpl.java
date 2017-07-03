package com.softserve.edu.service.impl;

import com.softserve.edu.dao.SaleDAO;
import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.Sale;
import com.softserve.edu.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private SaleDAO saleDAO;

    @Autowired
    public void setSaleDAO(SaleDAO saleDAO) {
        this.saleDAO = saleDAO;
    }


    @Transactional
    @Override
    public void addSale(Sale sale) {
        saleDAO.addElement(sale);
    }

    @Transactional
    @Override
    public void updateSale(Sale sale) {
        saleDAO.updateElement(sale);
    }

    @Transactional
    @Override
    public Sale getSaleById(int id) {
        return saleDAO.getElementById(id);
    }

    @Transactional
    @Override
    public void deleteSale(Sale sale) {
        saleDAO.deleteElement(sale);
    }

    @Transactional
    @Override
    public List<Sale> getAllSales() {
        return saleDAO.getAllElements();
    }

    @Transactional
    @Override
    public List<Sale> getAllSalesFromCart(Cart cart) {
        int cartId = cart.getId();
        return saleDAO.getAllSalesFromCart(cartId);
    }
}
