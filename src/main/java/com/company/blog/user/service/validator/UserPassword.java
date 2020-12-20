package com.company.blog.user.service.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Constraint(validatedBy = {UserPasswordValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserPassword {

    String message() default "{validation.user.password}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
