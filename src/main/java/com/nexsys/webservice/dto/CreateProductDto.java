package com.nexsys.webservice.dto;

import lombok.Data;

@Data
public class CreateProductDto {

    private int id;
    private String title;
    private int price;
    private String description;
    private int categoryId;
    private String[] images;

}
