package com.softserve.edu.validator;

import com.softserve.edu.entity.User;
import com.softserve.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for User
 */
@Component
public class UserValidator implements Validator{
    private UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user =(User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Required");

        if(user.getUsername().length()<8||user.getUsername().length()>32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        User tempValidationUser = userService.findByUsername(user.getUsername());
        if(tempValidationUser.getUsername()!=null){
            errors.rejectValue("username","Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if(user.getPassword().length()<8||user.getPassword().length()>32){
            errors.rejectValue("password", "Size.userForm.password");
        }
        if(!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }


    }
}
