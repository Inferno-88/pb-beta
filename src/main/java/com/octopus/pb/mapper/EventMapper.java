package com.octopus.pb.mapper;


import com.octopus.pb.dto.EventDto;
import com.octopus.pb.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto entityToDto(Event event);
    Event dtoToEntity(EventDto eventDto);
}