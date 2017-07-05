package com.softserve.edu.service.impl;

import com.softserve.edu.entity.SubmittedOrder;
import com.softserve.edu.entity.User;
import com.softserve.edu.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication
        .UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext()
                .getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails) userDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername
                (username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,
                        password, userDetails.getAuthorities());

        authenticationManager.authenticate(authenticationToken);

        if (authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication
                    (authenticationToken);
        }
    }

    public String getLoggedUserPhone() {
        UserServiceImpl userService = new UserServiceImpl();
        String phone;
        User user = userService.findByUsername(findLoggedInUsername());
        return user.getPhone();
    }

    public String getLoggedUserEmail() {
        UserServiceImpl userService = new UserServiceImpl();
        String email;
        User user = userService.findByUsername(findLoggedInUsername());
        return user.getEmail();
    }

    public List<SubmittedOrder> getLoggedUserOrdersList() {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findByUsername(findLoggedInUsername());
        return user.getUserOrdersList();
    }

    public int getLoggedUserId() {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findByUsername(findLoggedInUsername());
        return user.getId();
    }


}
