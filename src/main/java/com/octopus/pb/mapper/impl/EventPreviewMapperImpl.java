package com.octopus.pb.mapper.impl;

import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.mapper.EventPreviewMapper;
import org.springframework.stereotype.Component;

@Component
public class EventPreviewMapperImpl implements EventPreviewMapper {

    @Override
    public EventPreviewDto entityToDto(Event eventEntity) {

        return EventPreviewDto.builder()
                .id(eventEntity.getId())
                .name(eventEntity.getName())
                .date(eventEntity.getBeginDate())
                .peopleCount(800) //TODO Add field to Event entity
                .snippet("Краткое описание события") //TODO Add field to Event entity. Perhaps event details class?
                .field("Какое-то поле в лесу")
                .build();
    }

}
