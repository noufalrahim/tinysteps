package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.ArticleService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.ArticleEntity;
import com.nexorian.tinysteps.domain.repository.ArticleRepository;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleEntity, UUID> implements ArticleService {
    public ArticleServiceImpl(ArticleRepository articleRepository, JpaSpecificationExecutor<ArticleEntity> specRepository){
        super(articleRepository, specRepository, ArticleEntity.class);
    }
}
