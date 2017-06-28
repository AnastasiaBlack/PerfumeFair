package com.softserve.edu.service;

import com.softserve.edu.entity.Brand;

import java.util.HashSet;

public interface BrandService {
    void addBrand(Brand brand);

    void updateBrand(Brand brand);

    Brand getBrandByID(int brandID);

    void deleteBrand(Brand brand);

    HashSet<Brand> getAllBrands();
}
