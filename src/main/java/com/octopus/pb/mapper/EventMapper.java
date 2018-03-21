package com.octopus.pb.mapper;


import com.octopus.pb.dto.*;
import com.octopus.pb.entity.*;
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

    PlayerDto entityToDto(Player player, @Context CycleAvoidContext context);
    Player dtoToEntity(PlayerDto playerDto, @Context CycleAvoidContext context);

    RankDto entityToDto(Rank rank, @Context CycleAvoidContext context);
    Rank dtoToEntity(RankDto rankDto, @Context CycleAvoidContext context);

    TeamDto entityToDto(Team team, @Context CycleAvoidContext context);
    Team dtoToEntity(TeamDto teamDto, @Context CycleAvoidContext context);

    PhotoDto entityToDto(Photo photo, @Context CycleAvoidContext context);
    Photo dtoToEntity(PhotoDto photoDto, @Context CycleAvoidContext context);

    
}