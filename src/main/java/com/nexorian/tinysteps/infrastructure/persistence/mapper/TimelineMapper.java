package com.nexorian.tinysteps.infrastructure.persistence.mapper;

import com.nexorian.tinysteps.application.dto.ChildDTO;
import com.nexorian.tinysteps.application.dto.TimelineDTO;
import com.nexorian.tinysteps.domain.entity.TimelineEntity;

public class TimelineMapper {

    public static TimelineDTO toDTO(TimelineEntity timeline) {
        if (timeline == null) return null;

        ChildDTO childDTO = timeline.getChild() != null
                ? ChildMapper.toDTO(timeline.getChild())
                : null;

        return new TimelineDTO(
                timeline.getId(),
                childDTO,
                timeline.getTitle(),
                timeline.getDescription(),
                timeline.getDate()
        );
    }
}
