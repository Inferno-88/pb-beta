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
                .shortInfo("19 мая 2018 года под Москвой состоится главное пейнтбольное событие года - " +
                        "Большие Пейнтбольные Маневры™, самые крупные в Европе.")
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
    }

}
