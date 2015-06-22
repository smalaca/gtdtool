package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.applicationdomain.ApplicationError;
import com.smalaca.gtdtool.repository.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

import static com.smalaca.gtdtool.applicationdomain.ApplicationErrorType.INVALID_REQUEST_DATA;


@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApplicationError entityNotFound(HttpServletRequest request, EntityNotFoundException exception) {
        return new ApplicationError(INVALID_REQUEST_DATA, extractRequestUrl(request), exception.getMessage());
    }

    private String extractRequestUrl(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }
}
