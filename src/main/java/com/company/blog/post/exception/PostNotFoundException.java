package com.company.blog.post.exception;

import com.company.blog.util.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException() {
        super(Translator.getMessage("exception.post.not_found"));
    }
}
