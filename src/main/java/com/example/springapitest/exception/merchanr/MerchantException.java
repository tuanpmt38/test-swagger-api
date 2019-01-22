package com.example.springapitest.exception.merchanr;

import com.example.springapitest.exception.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@ControllerAdvice
public class MerchantException {

    public static final String DATA_NOT_FOUND = "Merchant.Exception.notfound";
    private final MessageSource messageSource;

    @Autowired
    public MerchantException(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MerchantNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleResourceNotFound(final MerchantNotFoundException exception,
                                                         final HttpServletRequest request,
                                                         Locale locale) {

        String statusCode ="404";
        String name = "MERCHANT_NOT_FOUND";
        String message = messageSource.getMessage(DATA_NOT_FOUND, null, locale);
        MessageError error = new MessageError(statusCode, name, message);

        return new ResponseEntity<Object>(
                error, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
