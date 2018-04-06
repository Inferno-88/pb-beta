package com.octopus.pb.data;


import com.octopus.pb.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class InitDataBuilder {


    private final EventRepository eventRepository;
    private final GroupRepository groupRepository;
    private final PlayerRepository playerRepository;
    private final FieldRepository fieldRepository;
    private final RatingRepository ratingRepository;
    private final RankRepository rankRepository;
    private final TeamRepository teamRepository;
    private final PhotoRepository photoRepository;


    public void buildData() {

    }

    public void buildEvents() {

    }

    public void buildPlayers() {

    }

    public void buildTeams() {

    }

    public void buildFields() {

    }

    public void buildPhotos() {

    }
    
}
