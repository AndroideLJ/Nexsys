package com.nexsys.webservice.controller;

import com.nexsys.webservice.dto.CategoryDto;
import com.nexsys.webservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nexsys/v1/categories/")

public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAllCategorys () { return categoryService.getAllCategory(); }
}
