package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.AgeGroupDTO;
import com.nexorian.tinysteps.application.dto.ArticleDTO;
import com.nexorian.tinysteps.domain.entity.ArticleEntity;

public class ArticleMapper {
    public static ArticleDTO toDTO(ArticleEntity article) {
        if (article == null) return null;

        AgeGroupDTO ageGroupDTO = article.getAgeGroup() != null
            ? AgeGroupMapper.toDTO(article.getAgeGroup())
            : null;


        return new ArticleDTO(
            article.getId(),
            article.getTitle(),
            article.getDescription(),
            article.getImage(),
            article.getLink(),
            ageGroupDTO
        );
    }
}