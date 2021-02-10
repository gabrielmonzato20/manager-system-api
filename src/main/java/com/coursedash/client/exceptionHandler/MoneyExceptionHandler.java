package com.coursedash.client.exceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MoneyExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        // TODO Auto-generated method stub
        String msgUser = messageSource.getMessage(
            "mensagem.invalid", 
            null,
            LocaleContextHolder.getLocale());
        String msgDev = Optional.ofNullable(ex.getCause()).orElse(ex).toString();
        List<Error> errors = Arrays.asList(new Error(msgUser,msgDev));
        return handleExceptionInternal(ex,
        errors,
        headers,
        HttpStatus.BAD_REQUEST,
        request);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
                List<Error> errors = showerrors(ex.getBindingResult());
                return handleExceptionInternal(ex, errors,headers,HttpStatus.BAD_REQUEST,request);

    }
    @ExceptionHandler({EmptyResultDataAccessException.class})
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
    WebRequest request){

        String msgUser = messageSource.getMessage(
            "resource.notFound", 
            null,
            LocaleContextHolder.getLocale());
        
        String msgDev = ex.toString();
        List<Error> errors = Arrays.asList(new Error(msgUser,msgDev));
        return handleExceptionInternal(ex, errors,new HttpHeaders(),
        HttpStatus.NOT_FOUND,request);

    }
    private List<Error> showerrors(BindingResult bindingResult){
        List<Error> errors=new ArrayList<Error>();
        for(FieldError err : bindingResult.getFieldErrors()){
            String msgDev = err.toString();
            String msgCleint=messageSource.getMessage(err, LocaleContextHolder.getLocale());
            errors.add(new Error(msgCleint,msgDev));
        }
        return errors;
    }
    public static class Error{
        private String msgUser;
        private String msgDev;

        public Error(String msgUser, String msgDev){
            this.msgDev= msgDev;
            this.msgUser =msgUser;
        }
        public String getMsgDev(){
            return this.msgDev;
        }
        public String getMsgUser(){
            return this.msgUser;
        }

    }
    
}
