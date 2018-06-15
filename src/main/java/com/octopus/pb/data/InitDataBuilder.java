package com.octopus.pb.data;


import com.octopus.pb.entity.*;
import com.octopus.pb.entity.security.RoleApp;
import com.octopus.pb.entity.security.UserApp;
import com.octopus.pb.enums.FieldType;
import com.octopus.pb.enums.GroupType;
import com.octopus.pb.enums.RankType;
import com.octopus.pb.enums.RoleType;
import com.octopus.pb.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.Month;


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
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Transactional
    public void buildData() {

        Field pkZarnica = Field.builder()
                .name("ПК ЗарницаКлаб")
                .address("Московская область, Истринский район, п.Борки")
                .info("Большая огороженная территория клуба «ЗарницаКлаб» подходит для проведения крупномасштабных " +
                        "пейнтбольных сценарных игр. Для проведения одновременно нескольких игр существуют " +
                        "удивительные сложные интересные игровые площадки с продуманной инфраструктурой, " +
                        "смоделированные при участии профессиональных пейнтболистов. " +
                        "Есть природные площадки – поля с деревьями, кустарниками, оврагами. " +
                        "Более сложные – двухэтажные дома с запутанными коридорами, темными подвалами, укромными комнатками.")
                .type(FieldType.FOREST)
                .capacity(500)
                .build();
        pkZarnica.addRating(new Rating());

        Field pkGvardiya = Field.builder()
                .name("ПК Гвардия")
                .address("Московская область, Пушкинский район, д. Костино, санаторий «Зеленый городок»")
                .info("Место расположения пейнтбольного клуба оказалось столь удачным, что именно в пейнтбол -клубе " +
                        "Гвардии впервые заговорили о серии сценарных пейнтбольных игр «Переправа», которые с успехом " +
                        "организовали на территории, прилегающей к клубу «Гвардия» с использованием водных преград " +
                        "(реки Скалба и заболоченных участков), огромного поля и безграничного лесного массива.\n" +
                        "\n" +
                        "Всего в наших сценарных играх используется более 10 Га территории. За последние годы уже " +
                        "состоялось 39 игр серии «Переправа», две из которых проводились зимой под названием «Ледовое Побоище». " +
                        "Так же последние 10 лет «Гвардия» является организатором самого масшатбного в Европе пейнтбольного мероприятия " +
                        "«Большие пейнтбольные маневры», в которых ежегодно принимают участия около 4000 человек. " +
                        "С каждым разом на «БПМ» съезжается все больше и больше поклонников пейнтбола .")
                .type(FieldType.FOREST)
                .rating(new Rating())
                .build();
        pkGvardiya.addRating(new Rating());

        pkZarnica = fieldRepository.save(pkZarnica);
        pkGvardiya = fieldRepository.save(pkGvardiya);

        Event fallout = Event.builder()
                .name("Фолаут ХI - Дорога Ярости")
                .info("\"Запретная Зона\" и пейнтбольный клуб \"Пейнтленд\" собщают, что 14.04.2018 мы планируем провести " +
                        "пейнтбольную постапоклаптичсекую традиционную масштабную ежегодную игру, по мотивам мира  Фолаут, " +
                        "данная игра станет уже 11 в серии, и мы проведем ее в лучших традициях игр данной серии.\n" +
                        "\n" +
                        "Как всегда вас ожидают \"фирменные\" сценарные отличия, 2 основных стороны со штабами и небольшая группа " +
                        "отмороженных \"нейтралов\", квесты для любителей \"не просто играть\", возможность проявить " +
                        "творчество и продемонстрировать традиционный для Fallout антураж, адреналин и пейнтбол - всё, как вы любите!")
                .shortInfo("\"Запретная Зона\" и пейнтбольный клуб \"Пейнтленд\" собщают, что 14.04.2018 мы планируем провести " +
                        "пейнтбольную постапоклаптичсекую традиционную масштабную ежегодную игру, по мотивам мира  Фолаут, " +
                        "данная игра станет уже 11 в серии, и мы проведем ее в лучших традициях игр данной серии.")
                .capacity(400)
                .beginDate(LocalDateTime.of(2018, Month.MAY, 14, 8, 0))
                .endDate(LocalDateTime.of(2018, Month.MAY, 14, 18, 0))
                .isActive(true)
                .field(pkZarnica)
                .build();
        fallout.addGroup(new Group(GroupType.RED));
        fallout.addGroup(new Group(GroupType.BLUE));

        Event bpm = Event.builder()
                .name("БПМ-2018: Южный фронт")
                .info("19 мая 2018 года под Москвой состоится главное пейнтбольное событие года - " +
                        "Большие Пейнтбольные Маневры™, самые крупные в Европе. В этом году мы отмечаем 20-летие БПМ и " +
                        "в честь этого повторяем тему самых первых Маневров 1998 года - \"Южный Фронт\".\n" +
                        "\n" +
                        "Основа сценария БПМ-2018 — решающее сражение Гражданской войны под Орлом и Кромами, в котором с " +
                        "обеих сторон сошлись лучшие и наиболее мотивированные части. «Слоеный пирог», черезполосица " +
                        "своих и чужих, сложившаяся на поле боя в октябре 1919 — что может быть более похоже на " +
                        "неразбериху большого пейнтбольного сражения! Сумеет ли Добровольческая армия пробиться к " +
                        "Москве или будет отброшена Ударной группой — зависит только от тебя!\n" +
                        "Упорная оборона позиций, отчаянные атаки и смелые кавалерийские рейды по тылам, захват " +
                        "«складов» со снабжением и «городов», поиски и засады, хитрые шпионы и не менее хитрые " +
                        "контрразведчики — все найдет отражение в сценарии. Победа зависит от выполненных заданий, " +
                        "а не от числа фрагов — да и кто их сосчитает на громадном поле с сотнями игроков? " +
                        "Играй, придумывай, пробуй новое, выполняй приказы штаба  — БПМ дает возможность попробовать любой стиль игры!\n" +
                        "\n" +
                        "\n")
                .shortInfo("19 мая 2018 года под Москвой состоится главное пейнтбольное событие года - " +
                        "Большие Пейнтбольные Маневры™, самые крупные в Европе.")
                .capacity(4000)
                .beginDate(LocalDateTime.of(2018, Month.MAY, 19, 7, 0))
                .endDate(LocalDateTime.of(2018, Month.MAY, 19, 19, 0))
                .isActive(true)
                .field(pkGvardiya)
                .build();
        bpm.addGroup(new Group(GroupType.RED));
        bpm.addGroup(new Group(GroupType.BLUE));

        eventRepository.save(fallout);
        eventRepository.save(bpm);

        //Players, Teams, Ranks
        Rank captainPlayerRank = new Rank("Captain", RankType.PLAYER);
        Rank sergeantPlayerRank = new Rank("Sergeant", RankType.PLAYER);
        Rank regularPlayerRank = new Rank("Regular", RankType.PLAYER);

        Player garik = new Player("Captain Geek++");
        Player inferno = new Player("INFERNO");
        Player gunter = new Player("Гантер");
        Player random1 = new Player("random1");
        Player random2 = new Player("random2");
        Player random3 = new Player("random3");

        garik.setRankAddPlayer(captainPlayerRank);
        inferno.setRankAddPlayer(sergeantPlayerRank);
        gunter.setRankAddPlayer(sergeantPlayerRank);
        random1.setRankAddPlayer(regularPlayerRank);
        random2.setRankAddPlayer(regularPlayerRank);
        random3.setRankAddPlayer(regularPlayerRank);

        garik = playerRepository.save(garik);
        inferno = playerRepository.save(inferno);
        gunter = playerRepository.save(gunter);
        random1 = playerRepository.save(random1);
        random2 = playerRepository.save(random2);
        random3 = playerRepository.save(random3);

        UserApp garikUser = new UserApp("garik", "garkik123", "garik@mail.ru");
        garikUser.addPlayer(garik);

        UserApp infernoUser = new UserApp("inferno", "inferno123", "inferno@mail.ru");
        infernoUser.addPlayer(inferno);

        UserApp gunterUser = new UserApp("gunter", "gunter123", "gunter@mail.ru");
        gunterUser.addPlayer(gunter);

        userRepository.save(garikUser);
        userRepository.save(infernoUser);
        userRepository.save(gunterUser);

        Rank teamFirstRank = new Rank("1", RankType.TEAM);
        Rank teamSecondRank = new Rank("2", RankType.TEAM);

        Team sonsOfErin = new Team("Sons Of Erin");
        sonsOfErin.addPlayer(garik);
        sonsOfErin.addPlayer(inferno);
        sonsOfErin.addPlayer(gunter);
        sonsOfErin.setRankAddTeam(teamFirstRank);

        Team randomTeam1 = new Team("Random Team1");
        randomTeam1.addPlayer(random1);
        randomTeam1.addPlayer(random2);
        randomTeam1.addPlayer(random3);
        randomTeam1.setRankAddTeam(teamSecondRank);

        teamRepository.save(sonsOfErin);
        teamRepository.save(randomTeam1);
    }

    public void createRoles() {
        RoleApp adminRole = new RoleApp(RoleType.ROLE_ADMIN);
        RoleApp userRole = new RoleApp(RoleType.ROLE_USER);

        roleRepository.save(adminRole);
        roleRepository.save(userRole);
    }

}
