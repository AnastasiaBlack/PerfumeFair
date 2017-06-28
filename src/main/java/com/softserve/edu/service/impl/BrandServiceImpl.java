package com.softserve.edu.service.impl;

import com.softserve.edu.dao.BrandDAO;
import com.softserve.edu.entity.Brand;
import com.softserve.edu.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;

@Service
public class BrandServiceImpl implements BrandService{
    private BrandDAO brandDAO;

    @Autowired
    public void setBrandDAO(BrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    @Transactional
    @Override
    public void addBrand(Brand brand) {
        brandDAO.addElement(brand);
//        DAOFactory.getInstance().getBrandDAOImpl().addElement(brand);
    }

    @Transactional
    @Override
    public void updateBrand(Brand brand) {
        brandDAO.updateElement(brand);
//        DAOFactory.getInstance().getBrandDAOImpl().updateElement(brand);
    }

    @Transactional
    @Override
    public Brand getBrandByID(int brandID) {
        Brand brand = brandDAO.getElementById(brandID);
//        Brand brand = DAOFactory.getInstance().getBrandDAOImpl().getElementById(brandID);
        return brand;
    }
    @Transactional
    @Override
    public void deleteBrand(Brand brand) {
        brandDAO.deleteElement(brand);
//        DAOFactory.getInstance().getBrandDAOImpl().deleteElement(brand);
    }


    @Transactional
    @Override
    public HashSet<Brand> getAllBrands() {
       return new HashSet<Brand>(brandDAO.getAllElements());
//        return new HashSet<Brand>(DAOFactory.getInstance().getBrandDAOImpl().getAllElements());
    }
}
