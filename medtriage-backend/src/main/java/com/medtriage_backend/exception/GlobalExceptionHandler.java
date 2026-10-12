package com.medtriage_backend.exception;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice; 
 
@RestControllerAdvice 
public class GlobalExceptionHandler { 
 
   @ExceptionHandler( 
       IllegalArgumentException.class 
   ) 
   public ProblemDetail handleIllegalArgument( 
           IllegalArgumentException ex) { 
       ProblemDetail problem =  
           ProblemDetail.forStatusAndDetail( 
               HttpStatus.BAD_REQUEST,  
               ex.getMessage() 
           ); 
       problem.setTitle( 
           "Solicitud Invalida de cita" 
       ); 
       problem.setType(URI.create( 
           "https://medtriage.ac.cr/errors/bad-request" 
       )); 
       problem.setProperty( 
           "timestamp", Instant.now() 
       ); 
       return problem; 
   } 
 
   @ExceptionHandler(RuntimeException.class) 
   public ProblemDetail handleRuntimeException( 
           RuntimeException ex) { 
       ProblemDetail problem =  
           ProblemDetail.forStatusAndDetail( 
               HttpStatus.NOT_FOUND,  
               ex.getMessage() 
           ); 
       problem.setTitle("Recurso No Encontrado"); 
       problem.setType(URI.create( 
           "https://medtriage.ac.cr/errors/not-found" 
       )); 
       problem.setProperty( 
           "timestamp", Instant.now()); 
       return problem; 
   } 
}