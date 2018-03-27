package com.octopus.pb.mapper;


import com.octopus.pb.dto.RankDto;
import com.octopus.pb.entity.Rank;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RankMapper {

    RankDto entityToDto(Rank rank, @Context CycleAvoidContext context);

    Rank dtoToEntity(RankDto rankDto, @Context CycleAvoidContext context);

}
