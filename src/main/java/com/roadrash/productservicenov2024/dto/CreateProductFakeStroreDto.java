package com.roadrash.productservicenov2024.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductFakeStroreDto {
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
