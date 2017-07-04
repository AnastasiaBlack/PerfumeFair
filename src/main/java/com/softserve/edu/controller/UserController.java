package com.softserve.edu.controller;

import com.softserve.edu.entity.Cart;
import com.softserve.edu.entity.User;
import com.softserve.edu.perspective.user.UserCartAction;
import com.softserve.edu.service.CartService;
import com.softserve.edu.service.SecurityService;
import com.softserve.edu.service.ServiceFactory;
import com.softserve.edu.service.UserService;
import com.softserve.edu.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Controller for User's pages
 */
@Controller
public class UserController {
    private Cart cart;
    private User user;
    private ServiceFactory serviceFactory = new ServiceFactory();
    private UserService userService;
    private CartService cartService;
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @Autowired
    public UserController(ServiceFactory serviceFactory) {
        this.userService=serviceFactory.getUserService();
        this.cartService=serviceFactory.getCartService();
        this.securityService=serviceFactory.getSecurityService();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult, Model model) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        Cart userCart = new Cart();
        userCart.setUser(userForm);
        cartService.addCart(userCart);


        securityService.autoLogin(userForm.getUsername(), userForm
                .getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out succesfully.");
        }
        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Principal principal, Model model) {
        UserCartAction act = new UserCartAction(serviceFactory);
        act.setUserAndCart(principal);


        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "editOffer";
    }


}
