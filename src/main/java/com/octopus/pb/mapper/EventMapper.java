package com.octopus.pb.mapper;


import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.FieldDto;
import com.octopus.pb.dto.GroupDto;
import com.octopus.pb.dto.RatingDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.entity.Field;
import com.octopus.pb.entity.Group;
import com.octopus.pb.entity.Rating;
import org.mapstruct.Context;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto entityToDto(Event event, @Context CycleAvoidContext context);
    Event dtoToEntity(EventDto eventDto, @Context CycleAvoidContext context);

    FieldDto entityToDto(Field field, @Context CycleAvoidContext context);
    Field dtoToEntity(FieldDto fieldDto, @Context CycleAvoidContext context);

    RatingDto entityToDto(Rating rating, @Context CycleAvoidContext context);
    Rating dtoToEntity(RatingDto ratingDto, @Context CycleAvoidContext context);

    GroupDto entityToDto(Group group, @Context CycleAvoidContext context);
    Group dtoToEntity(GroupDto groupDto, @Context CycleAvoidContext context);

}