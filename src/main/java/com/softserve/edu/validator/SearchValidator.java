package com.softserve.edu.validator;
import com.softserve.edu.controller.auxiliary.TransitSearchByBrandAndPriceData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for User
 */
@Component
public class SearchValidator implements Validator{

    public SearchValidator() {
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return TransitSearchByBrandAndPriceData.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TransitSearchByBrandAndPriceData transitData =(TransitSearchByBrandAndPriceData)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"brandName","Required");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxPrice", "Required");
        if(!transitData.getMaxPrice().matches("\\d*")){
            errors.rejectValue("maxPrice","NumberRequired");
        }
    }
}
