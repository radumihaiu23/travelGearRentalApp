package com.itschool.travelGearRentalApp.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(CustomerEmailAlreadyExistsException.class)
    public ResponseEntity<String> customerEmailAlreadyExistsException(CustomerEmailAlreadyExistsException customerEmailAlreadyExistsException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerEmailAlreadyExistsException.getMessage())), FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException customerNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerNotFoundException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(CustomerFirstNameAlreadyExistsException.class)
    public ResponseEntity<String> customerFirstNameAlreadyExistsException(CustomerFirstNameAlreadyExistsException customerFirstNameAlreadyExistsException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerFirstNameAlreadyExistsException.getMessage())), FOUND);
    }

    @ExceptionHandler(CustomerLastNameAlreadyExistsException.class)
    public ResponseEntity<String> customerLastNameAlreadyExistsException(CustomerLastNameAlreadyExistsException customerLastNameAlreadyExistsException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerLastNameAlreadyExistsException.getMessage())), FOUND);
    }

    @ExceptionHandler(CustomerDatabaseIsEmptyException.class)
    public ResponseEntity<String> customerDatabaseIsEmpty(CustomerDatabaseIsEmptyException customerDatabaseIsEmptyException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerDatabaseIsEmptyException.getMessage())), NO_CONTENT);
    }

    @ExceptionHandler(ItemNameAlreadyExistsException.class)
    public ResponseEntity<String> itemNameAlreadyExistsException(ItemNameAlreadyExistsException itemNameAlreadyExistsException) {
        return new ResponseEntity<>(objectToString(Map.of("message", itemNameAlreadyExistsException.getMessage())), FOUND);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> itemNotFoundException(ItemNotFoundException itemNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", itemNotFoundException.getMessage())), BAD_REQUEST);
    }

    @ExceptionHandler(ItemDatabaseIsEmptyException.class)
    public ResponseEntity<String> itemNotFoundException(ItemDatabaseIsEmptyException itemDatabaseIsEmptyException) {
        return new ResponseEntity<>(objectToString(Map.of("message", itemDatabaseIsEmptyException.getMessage())), NO_CONTENT);
    }





    private String objectToString(Object response) {
        try {
            return objectMapper.writeValueAsString(response);

        } catch (JsonProcessingException e) {
            log.error("Error processing response to string");
            return "Internal error";
        }
    }
}