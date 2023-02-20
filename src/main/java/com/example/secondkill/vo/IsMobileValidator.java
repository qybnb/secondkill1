package com.example.secondkill.vo;

import com.example.secondkill.utils.ValidatorUtil;
import com.example.secondkill.validator.IsMobile;
import org.thymeleaf.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
    private boolean required=false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        boolean required= constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorUtil.isMobile(value);
        }
        else{
            if(StringUtils.isEmpty(value)){
                return true;
            }
            else{
                return ValidatorUtil.isMobile(value);
            }
        }

    }
}
