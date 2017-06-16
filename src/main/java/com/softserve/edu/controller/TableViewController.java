package com.softserve.edu.controller;

import com.softserve.edu.entity.Brand;
import com.softserve.edu.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;


@Controller
public class TableViewController {
    BrandService brandService = new BrandService();


    @RequestMapping("/brandsList.html")
    @ModelAttribute("brands")
    public Collection<Brand> getBrands() {
        Collection<Brand> allBrands = brandService.getAllBrands();
       return allBrands;
    }
}
