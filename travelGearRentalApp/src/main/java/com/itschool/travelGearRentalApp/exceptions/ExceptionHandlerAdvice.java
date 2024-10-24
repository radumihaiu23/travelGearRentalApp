package com.itschool.travelGearRentalApp.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    private final ObjectMapper objectMapper;

    public ExceptionHandlerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException customerNotFoundException) {
        return new ResponseEntity<>(objectToString(Map.of("message", customerNotFoundException.getMessage())), BAD_REQUEST);
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