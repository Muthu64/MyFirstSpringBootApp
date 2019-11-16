package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TopicExceptionHandler extends ResponseEntityExceptionHandler
{
    @SuppressWarnings( {"unchecked", "rawtypes"} )
    @ExceptionHandler( TopicException.class )
    public final ResponseEntity<Object> handleAllExceptions( TopicException topicException )
    {
        System.out.println( "Error Happenned---->" + topicException.getErrorCode() + "-----" + topicException.getErrorList() );
        GernericErrorResponse genericErrorResponse = new GernericErrorResponse( topicException.getErrorList(), topicException.isErrorFound(), topicException.getErrorCode() );
        return new ResponseEntity( genericErrorResponse, null, HttpStatus.BAD_REQUEST );
    }

}
