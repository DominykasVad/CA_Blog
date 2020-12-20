package com.company.blog.user.service.validator;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class UserPasswordValidator implements ConstraintValidator<UserPassword, String> {

    /**
     * Checks password for following rules
     * Length is from 6 to 20 characters
     * Contains 1 uppercase character
     * Contains 1 number character
     * Has no whitespace characters
     */
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Do not validate existing passwords
        if (password.startsWith("{bcrypt}")) {
            return true;
        }
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                // Length from 6 to 30 characters
                new LengthRule(6, 20),
                // Contains 1 uppercase character
                new UppercaseCharacterRule(1),
                // Contains 1 number character
                new DigitCharacterRule(1),
                // No whitespace characters
                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));
        return result.isValid();
    }
}
