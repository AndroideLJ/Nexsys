package com.nexsys.webservice.service;

import com.nexsys.webservice.dto.CategoryDto;
import com.nexsys.webservice.dto.CategoryPlatziDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final RestTemplate restTemplate;

    public List<CategoryDto> getAllCategory() {
        var response = restTemplate.exchange(
                "https://api.escuelajs.co/api/v1/categories",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CategoryPlatziDto>>() {
                });

        return response.getBody().stream().map(dto -> CategoryDto.builder()
                .cid(dto.getId())
                .title(dto.getName())
                .build()).toList();
    }
}
