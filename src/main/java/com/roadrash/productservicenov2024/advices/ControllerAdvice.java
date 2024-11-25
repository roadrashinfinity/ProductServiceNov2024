package com.roadrash.productservicenov2024.advices;

import com.roadrash.productservicenov2024.dto.ErrorDTO;
import com.roadrash.productservicenov2024.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException e) {
        ErrorDTO errorDTO=new ErrorDTO();
        errorDTO.setMessage(e.getMessage());

        ResponseEntity<ErrorDTO> responseEntity=new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
