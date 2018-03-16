package com.octopus.pb.mapper;


import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.FieldDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.entity.Field;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto entityToDto(Event event, @Context CycleAvoidContext context);
    Event dtoToEntity(EventDto eventDto, @Context CycleAvoidContext context);


    FieldDto entityToDto(Field field, @Context CycleAvoidContext context);
    Field dtoToEntity(FieldDto fieldDto, @Context CycleAvoidContext context);

}