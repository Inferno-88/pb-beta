package com.octopus.pb.service.impl;

import com.octopus.pb.dto.EventDto;
import com.octopus.pb.dto.EventPreviewDto;
import com.octopus.pb.entity.Event;
import com.octopus.pb.manager.Mediator;
import com.octopus.pb.mapper.CycleAvoidContext;
import com.octopus.pb.mapper.DtoMapper;
import com.octopus.pb.mapper.EventPreviewMapper;
import com.octopus.pb.repository.EventRepository;
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
    private final EventRepository eventRepository;
    private final CycleAvoidContext cycleAvoidContext;

    @PostConstruct
    private void init() {
        log.info("************** Preparing {} **************", EventService.class);
    }
    
    public EventPreviewDto getEventPreviewDto(int id) {
        return eventPreviewMapper.entityToDto(getEvent(id));
    }

    public List<EventPreviewDto> getEventPreviewDtoList() {
        return getEventList().stream()
                .map(e -> eventPreviewMapper.entityToDto(e))
                .collect(Collectors.toList());
    }

    public List<EventDto> getEventDtoList() {
        return getEventList().stream()
                .map(e -> dtoMapper.entityToDto(e, cycleAvoidContext))
                .collect(Collectors.toList());
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findOne(id);
    }

    @Override
    public List<Event> getEventList() {
        return eventRepository.findAll();
    }



}
