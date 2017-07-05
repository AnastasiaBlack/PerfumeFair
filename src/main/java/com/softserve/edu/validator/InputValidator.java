package com.softserve.edu.validator;

import com.softserve.edu.controller.auxiliary.TransitOffer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for new Offer input data
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
        if(!transitOffer.getPrice().matches("\\d*")){
            errors.rejectValue("price","NumberRequired");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "volumeForSale", "Required");
        if(!transitOffer.getVolumeForSale().matches("\\d*")){
            errors.rejectValue("volumeForSale","NumberRequired");
        }
    }
}
