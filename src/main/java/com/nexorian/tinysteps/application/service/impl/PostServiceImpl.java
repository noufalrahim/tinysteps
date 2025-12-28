package com.nexorian.tinysteps.application.service.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.nexorian.tinysteps.application.service.PostService;
import com.nexorian.tinysteps.application.service.impl.base.BaseServiceImpl;
import com.nexorian.tinysteps.domain.entity.PostEntity;
import com.nexorian.tinysteps.domain.repository.PostRepository;

@Service
public class PostServiceImpl extends BaseServiceImpl<PostEntity, UUID> implements PostService {
    public PostServiceImpl(PostRepository postRepository, JpaSpecificationExecutor<PostEntity> specRepository){
        super(postRepository, specRepository, PostEntity.class);
    }
}
