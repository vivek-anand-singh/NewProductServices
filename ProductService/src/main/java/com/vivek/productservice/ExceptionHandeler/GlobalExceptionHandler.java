package com.vivek.productservice.ExceptionHandeler;

import com.vivek.productservice.DTOS.ExceptionDto;
import com.vivek.productservice.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Arithmetic Exception");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundException() {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Array Index out of bound Exception");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public ResponseEntity<ExceptionDto> handleGeneralException() {
//        ExceptionDto dto = new ExceptionDto();
//        dto.setMessage("Something went wrong");
//        dto.setResolution("General Exception");
//        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid Product ID " + productNotFoundException.getId()+" passed");
        dto.setResolution("Product Not Found Exception");
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
