package com.softserve.edu.validator;

import com.softserve.edu.controller.auxiliary.TransitOffer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for User
 */
@Component
public class InputValidator implements Validator{

    public InputValidator() {
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return TransitOffer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TransitOffer transitOffer =(TransitOffer)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"perfumeName","Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brandName", "Required");
//        if(user.getPassword().length()<8||user.getPassword().length()>32){
//            errors.rejectValue("password", "Size.userForm.password");
//        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "volumeForSale", "Required");

    }
}
