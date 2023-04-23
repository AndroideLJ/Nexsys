package com.nexsys.webservice.service;

import com.nexsys.webservice.dto.CreateProductDto;
import com.nexsys.webservice.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final RestTemplate restTemplate;

    public List<ProductDto> getAllProducts() {
        var response = restTemplate.exchange(
                "https://api.escuelajs.co/api/v1/products",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDto>>() {
                });

        return response.getBody();
    }

    public int createProducts(CreateProductDto createProductDto) {
        HttpEntity<CreateProductDto> entity = new HttpEntity<CreateProductDto>(createProductDto,null);
        var response = restTemplate.exchange(
                "https://api.escuelajs.co/api/v1/products/",
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<CreateProductDto>() {
                });


        return response.getBody().getId();
    }
}
