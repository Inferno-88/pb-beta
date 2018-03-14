package com.octopus.pb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
public class EventPreviewDto {

    private int id;
    private String name;
    private LocalDateTime date;
    private int peopleCount;
    private String snippet;
    private String field;

}
