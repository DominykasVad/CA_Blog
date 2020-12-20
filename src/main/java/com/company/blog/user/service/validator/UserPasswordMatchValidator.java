package com.company.blog.user.service.validator;

import com.company.blog.user.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserPasswordMatchValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (!(user.getPassword().equals(user.getRepeatedPassword()))) {
            errors.rejectValue("password", "validation.password.no_match");
        }
    }
}
