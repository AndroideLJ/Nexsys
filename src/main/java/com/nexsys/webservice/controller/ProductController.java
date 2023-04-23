package com.nexsys.webservice.controller;


import com.nexsys.webservice.dto.CreateProductDto;
import com.nexsys.webservice.dto.ProductDto;
import com.nexsys.webservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nexsys/v1/products/")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> allProducts ()
    {
        return productService.getAllProducts();
    }

    @PostMapping
    public int crateProduct (@RequestBody CreateProductDto createProductDto)
    {
        return productService.createProducts(createProductDto);
    }
}