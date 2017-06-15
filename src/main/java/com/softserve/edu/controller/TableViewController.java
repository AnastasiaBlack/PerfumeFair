package com.softserve.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TableViewController  {

    @RequestMapping(value = "/table")
    public ModelAndView welcomeMessage() {
        // Name of your jsp file as parameter
        ModelAndView view = new ModelAndView("table");
        return view;
    }
}
