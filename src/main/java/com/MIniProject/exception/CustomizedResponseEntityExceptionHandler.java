package com.MIniProject.exception;


import com.MIniProject.constant.StatusConstant;
import com.MIniProject.model.Response;
import com.MIniProject.model.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Status errorDetail = new Status(StatusConstant.HttpConstant.CUSTOM_FIELD_VALIDATION.getCode(),
                ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity(new Response(errorDetail, null), HttpStatus.BAD_REQUEST);
    }
}
