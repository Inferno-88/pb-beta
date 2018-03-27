package com.octopus.pb.repository;


import com.octopus.pb.enums.*;
import com.octopus.pb.entity.*;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Slf4j
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/db-wipe.sql")
public class AllRepositoryTest {

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PhotoRepository photoRepository;


    @Test
    public void testContextLoader() {
        assertTrue(8 == 8);
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:sql/player-repository.sql")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:sql/db-wipe.sql")
    public void testPlayerGet() {

        Player player1 = playerRepository.findOne(1);
        Player player2 = playerRepository.findOne(2);
        Player player3 = playerRepository.findOne(3);
        Player player88 = playerRepository.findOne(88);

        assertEquals("Player1 name does not match", player1.getName(), "inserted_player_1");
        assertEquals("Player2 name does not match", player2.getName(), "inserted_player_2");
        assertEquals("Player3 name does not match", player3.getName(), "inserted_player_3");
        assertEquals("Player88 name does not match", player88.getName(), "inserted_player_88");
    }

    @Test
    public void testPlayerSave() {

        List<Player> playerList1 = new ArrayList<>();
        playerList1.add(new Player("One"));
        playerList1.add(new Player("Two"));
        playerList1.add(new Player("Three"));

        List<Player> playerList2 = new ArrayList<>();
        playerList2.add(new Player("Four"));
        playerList2.add(new Player("Five"));

        List<Player> savedList1 = playerRepository.save(playerList1);
        List<Player> savedList2 = playerRepository.save(playerList2);

        savedList1.forEach(p -> log.info("List1 ID: " + p.getId()));
        savedList2.forEach(p -> log.info("List2 ID: " + p.getId()));

        assertTrue("SavedList1 size is not 3", savedList1.size() == 3);
        assertTrue("SavedList2 size is not 2", savedList2.size() == 2);
    }

    @Test
    public void testTeamSave() {

        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        Team savedTeam1 = teamRepository.save(team1);
        Team savedTeam2 = teamRepository.save(team2);

        assertEquals("SavedTeam1 name does not match", savedTeam1.getName(), "Team1");
        assertEquals("SavedTeam2 name does not match", savedTeam2.getName(), "Team2");
    }

    @Test
    public void testEventSave() {

        Event event1 = new Event("FirstEvent");

        Group group1 = new Group(GroupType.RED);
        Group group2 = new Group(GroupType.BLUE);

        List<Group> groupList = new ArrayList<>();
        groupList.add(group1);
        groupList.add(group2);

        event1.addGroupList(groupList);

        eventRepository.save(event1);
    }

    @Test
    public void testGroupSave() {

        Group group1 = new Group(GroupType.BLUE);
        Group group2 = new Group(GroupType.RED);
        Group group3 = new Group(GroupType.YELLOW);

        Group savedGroup1 = groupRepository.save(group1);
        Group savedGroup2 = groupRepository.save(group2);
        Group savedGroup3 = groupRepository.save(group3);

        assertEquals("SavedGroup1 name does not match", savedGroup1.getGroupType().toString(), "BLUE");
        assertEquals("SavedGroup1 name does not match", savedGroup2.getGroupType().toString(), "RED");
        assertEquals("SavedGroup1 name does not match", savedGroup3.getGroupType().toString(), "YELLOW");
    }

    @Test
    public void testCascadeSave() {

        log.info("Save data in DB");
        Rank playerRank1 = new Rank("Knight", RankType.PLAYER);
        Rank playerRank2 = new Rank("Marshal", RankType.PLAYER);

        Rank teamRank1 = new Rank("Bronze", RankType.TEAM);
        Rank teamRank2 = new Rank("Silver", RankType.TEAM);
        Rank teamRank3 = new Rank("Gold", RankType.TEAM); //won't be added by eventRepository cascade save

        Rating fieldRating1 = new Rating();
        Rating fieldRating2 = new Rating(); //won't be added by eventRepository cascade save

        Field field1 = new Field("Sport");
        Field field2 = new Field("Forest"); //won't be added by eventRepository cascade save
        field1.addRating(fieldRating1);
        field2.addRating(fieldRating2);

        Player player1 = new Player("Captain Geek++");
        Player player2 = new Player("Newbie");
        Player player3 = new Player("LoL");
        player1.setRankAddPlayer(playerRank1);
        player2.setRankAddPlayer(playerRank2);

        Team team1 = new Team("Brazilian Trucker Cleave");
        Team team2 = new Team("The Void");
        Team team3 = new Team("MVP"); //won't be added by eventRepository cascade save
        team1.setRankAddTeam(teamRank1);
        team2.setRankAddTeam(teamRank2);
        team3.setRankAddTeam(teamRank3);

        team1.addPlayer(player1);
        team2.addPlayer(player2);

        User user1 = new User("someUser1", "somePassword1", "someemail1@email.com");
        User user2 = new User("someUser2", "somePassword2", "someemail2@email.com");
        user1.addPlayer(player1);
        user2.addPlayer(player2);

        Group group1 = new Group(GroupType.RED);
        Group group2 = new Group(GroupType.BLUE);
        group1.addPlayer(player1);
        group2.addPlayer(player2);

        Event event1 = new Event("BPM");
        Event event2 = new Event("OPM"); //won't be added by eventRepository cascade save
        event1.addField(field1);
        event1.addGroup(group1);
        event1.addGroup(group2);

        Photo playerPhoto1 = new Photo("/path/playerPhoto1", PhotoType.PLAYER);
        Photo playerPhoto2 = new Photo("/path/playerPhoto2", PhotoType.PLAYER); //won't be added by eventRepository cascade save
        Photo teamPhoto1 = new Photo("/path/teamPhoto1", PhotoType.TEAM);
        Photo fieldPhoto1 = new Photo("/path/fieldPhoto1", PhotoType.FIELD);
        Photo eventPhoto1 = new Photo("/path/eventPhoto1", PhotoType.EVENT);
        playerPhoto1.addPlayer(player1);
        teamPhoto1.addTeam(team1);
        fieldPhoto1.addField(field1);
        eventPhoto1.addEvent(event1);

        eventRepository.save(event1);

        log.info("Get data from DB");

        List<Rank> savedRankList = rankRepository.findAll();
        assertTrue("SavedRankList does not contain playerRank1", savedRankList.contains(playerRank1));
        assertTrue("SavedRankList does not contain playerRank2", savedRankList.contains(playerRank2));
        assertTrue("SavedRankList does not contain teamRank1", savedRankList.contains(teamRank1));
        assertTrue("SavedRankList does not contain teamRank2", savedRankList.contains(teamRank2));
        assertFalse("SavedRankList contains teamRank3", savedRankList.contains(teamRank3));

        List<Rating> savedRatingList = ratingRepository.findAll();
        assertTrue("SavedRatingList does not contain fieldRating1", savedRatingList.contains(fieldRating1));
        assertFalse("SavedRatingList contains fieldRating2", savedRatingList.contains(fieldRating2));

        List<Team> savedTeamList = teamRepository.findAll();
        assertTrue("SavedTeamList does not contain team1", savedTeamList.contains(team1));
        assertTrue("SavedTeamList does not contain team2", savedTeamList.contains(team2));
        assertFalse("SavedTeamList contains team3", savedTeamList.contains(team3));

        List<Player> savedPlayerList = playerRepository.findAll();
        assertTrue("SavedPlayerList does not contain player1", savedPlayerList.contains(player1));
        assertTrue("SavedPlayerList does not contain player2", savedPlayerList.contains(player2));
        assertFalse("SavedPlayerList contains player3", savedPlayerList.contains(player3));

        List<User> savedUserList = userRepository.findAll();
        assertTrue("SavedUserList does not contain user1", savedUserList.contains(user1));
        assertTrue("SavedUserList does not contain user2", savedUserList.contains(user2));

        List<Group> savedGroupList = groupRepository.findAll();
        assertTrue("SavedGroupList does not contain group1", savedGroupList.contains(group1));
        assertTrue("SavedGroupList does not contain group1", savedGroupList.contains(group2));

        List<Field> savedFieldList = fieldRepository.findAll();
        assertTrue("SavedFieldList does not contain field1", savedFieldList.contains(field1));
        assertFalse("SavedFieldList contains field2", savedFieldList.contains(field2));

        List<Event> savedEventList = eventRepository.findAll();
        assertTrue("SavedEventList does not contain event1", savedEventList.contains(event1));
        assertFalse("SavedEventList contains event2", savedEventList.contains(event2));

        List<Photo> savedPhotoList = photoRepository.findAll();
        assertTrue("SavedPhotoList does not contant playerPhoto1", savedPhotoList.contains(playerPhoto1));
        assertTrue("SavedPhotoList does not contant teamPhoto1", savedPhotoList.contains(teamPhoto1));
        assertTrue("SavedPhotoList does not contant fieldPhoto1", savedPhotoList.contains(fieldPhoto1));
        assertTrue("SavedPhotoList does not contant eventPhoto1", savedPhotoList.contains(eventPhoto1));
        assertFalse("SavedPhotoList contains playerPhoto2", savedPhotoList.contains(playerPhoto2));
    }

    @Test
    public void testCascadeDelete() {

        //TODO cascade delete
    }

}
