package com.octopus.pb.mapper;


import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;

public interface EventPreviewMapper {

    EventPreviewDto entityToDto (Event eventEntity);

}
