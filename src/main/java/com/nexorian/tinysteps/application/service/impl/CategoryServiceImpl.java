package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.CategoryService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.CategoryEntity;
import com.nexorian.tinysteps.domain.repository.CategoryRepository;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryEntity, UUID> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository categoryRepository, JpaSpecificationExecutor<CategoryEntity> specRepository){
        super(categoryRepository, specRepository, CategoryEntity.class);
    }
}
