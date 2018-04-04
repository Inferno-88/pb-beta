package com.octopus.pb.manager.impl;


import com.octopus.pb.manager.Mediator;
import com.octopus.pb.repository.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class MediatorImpl implements Mediator {

    private final EventRepository eventRepository;
    private final FieldRepository fieldRepository;
    private final GroupRepository groupRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PhotoRepository photoRepository;
    private final RankRepository rankRepository;
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;


    @Override
    public <T extends CrudRepository, R> T getRepo(String repoName) {

        switch (repoName) {
            case "Event" :
                return (T) eventRepository;

            case "Group" :
                return (T) groupRepository;

            case "Player" :
                return (T) playerRepository;

            default : throw new IllegalArgumentException("Repository not found. Incorrect repository name.");
        }
    }

//    @Override
//    public <T extends CrudRepository, R> T getRepository(Class<R> serviceName) {
//
//        switch (serviceName.getSimpleName()) {
//            case "EventService" :
//                return (T) eventRepository;
//
//            case "GroupService" :
//                return (T) groupRepository;
//
//            default : throw new IllegalArgumentException("Repository not found. Incorrect interface name.");
//        }
//    }

}