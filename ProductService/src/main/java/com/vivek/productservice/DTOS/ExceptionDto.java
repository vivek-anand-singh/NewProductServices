package com.vivek.productservice.DTOS;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionDto {
    private String message;
    private String resolution;
}
