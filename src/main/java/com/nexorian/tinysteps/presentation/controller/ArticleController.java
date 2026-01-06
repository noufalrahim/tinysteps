package com.nexorian.tinysteps.presentation.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexorian.tinysteps.application.dto.ArticleDTO;
import com.nexorian.tinysteps.application.service.ArticleService;
import com.nexorian.tinysteps.domain.entity.ArticleEntity;
import com.nexorian.tinysteps.infrastructure.persistence.mapper.ArticleMapper;
import com.nexorian.tinysteps.presentation.controller.base.BaseController;

@RestController
@RequestMapping("/articles")

public class ArticleController extends BaseController<ArticleEntity, ArticleDTO, UUID> {
    public ArticleController(ArticleService service) {
        super(service, ArticleMapper::toDTO);
    }
}