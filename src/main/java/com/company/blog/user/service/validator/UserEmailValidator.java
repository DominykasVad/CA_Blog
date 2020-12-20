package com.company.blog.user.service.validator;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserEmailValidator implements ConstraintValidator<UserEmail, String> {

    /**
     * Email validator using Apache commons validator
     * john@domain.xx is valid
     * local@host is not valid
     */
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        EmailValidator emailValidator = EmailValidator.getInstance(false, true);
        return emailValidator.isValid(email);
    }
}
