package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.entity.Brand;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BrandService {
    @Transactional
    public void addBrand(Brand brand) {
        DAOFactory.getInstance().getBrandDAO().addElement(brand);
    }

    @Transactional
    public void updateBrand(Brand brand) {
        DAOFactory.getInstance().getBrandDAO().updateElement(brand);
    }

    @Transactional
    public Brand getBrandByID(int brandID) {
        Brand brand = DAOFactory.getInstance().getBrandDAO().getElementById(brandID);
        return brand;
    }
    @Transactional
    public void deleteBrand(Brand brand) {
        DAOFactory.getInstance().getBrandDAO().deleteElement(brand);
    }

//    @Transactional
//    public List<Brand> getAllBrands() {
//        return DAOFactory.getInstance().getBrandDAO().getAllElements();
//    }

    @Transactional
    public HashSet<Brand> getAllBrands() {
        return new HashSet<Brand>(DAOFactory.getInstance().getBrandDAO().getAllElements());
    }
}
