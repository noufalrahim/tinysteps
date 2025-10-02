package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.CategoryDTO;
import com.nexorian.tinysteps.application.service.CategoryService;
import com.nexorian.tinysteps.domain.entity.CategoryEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.CategoryMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<CategoryEntity, CategoryDTO, UUID> {

    public CategoryController(CategoryService service) {
        super(service, CategoryMapper::toDTO);
    }
}
