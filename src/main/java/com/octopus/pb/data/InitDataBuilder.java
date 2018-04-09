package com.octopus.pb.data;


import com.octopus.pb.entity.Event;
import com.octopus.pb.entity.Field;
import com.octopus.pb.entity.Group;
import com.octopus.pb.entity.Rating;
import com.octopus.pb.enums.FieldType;
import com.octopus.pb.enums.GroupType;
import com.octopus.pb.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


    public void buildData() {

        Rating rating1 = new Rating();
        Rating rating2 = new Rating();

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
                .capacity(400)
                .build();

        pkZarnica.addRating(rating1);

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

        pkGvardiya.addRating(rating2);

        Group group1 = new Group(GroupType.RED);
        Group group2 = new Group(GroupType.BLUE);

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
                .build();
    }

    public void buildPhotos() {

    }

}
