package com.octopus.pb.service.impl;

import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.manager.Mediator;
import com.octopus.pb.mapper.CycleAvoidContext;
import com.octopus.pb.mapper.DtoMapper;
import com.octopus.pb.mapper.EventPreviewMapper;
import com.octopus.pb.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class EventServiceImpl implements EventService {

    private final Mediator mediator;
    private final DtoMapper dtoMapper;
    private final EventPreviewMapper eventPreviewMapper;
    private final CycleAvoidContext cycleAvoidContext;

    @PostConstruct
    private void init() {
        log.info("************** Preparing {} **************", EventService.class);
    }

    @Override
    public EventPreviewDto getEventPreviewDto(int id) {
        return eventPreviewMapper.entityToDto(get(id));
    }

    @Override
    public List<EventPreviewDto> getEventPreviewDtoList() {
        return getList().stream()
                .map(e -> eventPreviewMapper.entityToDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public EventDto getEventDto(int id) {
        return dtoMapper.entityToDto(get(id), cycleAvoidContext);
    }

    @Override
    public List<EventDto> getEventDtoList() {
        return getList().stream()
                .map(e -> dtoMapper.entityToDto(e, cycleAvoidContext))
                .collect(Collectors.toList());
    }

    @Override
    public EventDto createEventDto(EventDto eventDto) {

        Event event = dtoMapper.dtoToEntity(eventDto, cycleAvoidContext);
        event = save(event);

        return dtoMapper.entityToDto(event, cycleAvoidContext);
    }

    @Override
    public Event save(Event event) {
        return (Event) mediator.getRepo("Event").save(event);
    }

    @Override
    public void delete(Event event) {
        mediator.getRepo("Event").delete(event);
    }

    @Override
    public Event get(int id) {
        return (Event) mediator.getRepo("Event").findOne(id);
    }

    @Override
    public List<Event> getList() {
        return (List<Event>) mediator.getRepo("Event").findAll();
    }

}
