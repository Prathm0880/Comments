package com.microservice.comments.Exception;

import com.microservice.comments.Payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.xml.crypto.Data;
import java.util.Date;

@RestControllerAdvice
public class GloballyHandle {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>handleException(Exception e , WebRequest web){
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                e.getMessage(),
                web.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
