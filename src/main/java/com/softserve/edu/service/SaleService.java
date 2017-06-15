package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.entity.Sale;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class SaleService {
    @Transactional
    public void addSale(Sale sale) {
        DAOFactory.getInstance().getSaleDAO().addElement(sale);
    }

    @Transactional
    public void updateSale(Sale sale) {
        DAOFactory.getInstance().getSaleDAO().updateElement(sale);
    }

    @Transactional
    public Sale getSaleById(int id) {
        Sale sale = DAOFactory.getInstance().getSaleDAO().getElementById(id);
        return sale;
    }
    @Transactional
    public void deleteSale(Sale sale) {
        DAOFactory.getInstance().getSaleDAO().deleteElement(sale);
    }

    @Transactional
    public List<Sale> getAllSales() {
        return DAOFactory.getInstance().getSaleDAO().getAllElements();
    }
}
