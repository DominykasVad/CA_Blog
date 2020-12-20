package com.company.blog.user.exception;

import com.company.blog.util.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(Translator.getMessage("exception.comment.not_found"));
    }
}
