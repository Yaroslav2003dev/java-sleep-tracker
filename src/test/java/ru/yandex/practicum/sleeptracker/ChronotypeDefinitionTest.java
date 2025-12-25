package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ChronotypeDefinitionTest {
    @Test
    @DisplayName("Получение хронотипа 'Сова', когда засыпание было после 23:00, а время пробуждения — после 9:00")
    void testDefine_whenFallingSleepAfter23AndWakingUpAfter9_True() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        ChronotypeDefinition chronotypeDefinition = new ChronotypeDefinition();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 23, 20), LocalDateTime.of(2026, 1, 1, 10, 0), SleepQuality.GOOD));
        //when
        LocalTime sleep;
        LocalTime wake;
        for (int i = 0; i < sleepingSessionList.size(); i++) {
            sleep = sleepingSessionList.get(i).sleep.toLocalTime();
            wake = sleepingSessionList.get(i).wake.toLocalTime();
            chronotypeDefinition.define(sleep, wake);
        }
        //then
        Assertions.assertTrue("Сова".equals(chronotypeDefinition.printDefinition()), "Ожидается хронотип Сова");
    }

    @Test
    @DisplayName("Получение хронотипа 'Жаворонок', когда время засыпания было до 22:00, а время пробуждения до — 7:00")
    void testDefine_whenFallingSleepBefore22AndWakingUpBefore7_True() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        ChronotypeDefinition chronotypeDefinition = new ChronotypeDefinition();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 21, 0), LocalDateTime.of(2026, 1, 1, 5, 0), SleepQuality.GOOD));
        //when
        LocalTime sleep;
        LocalTime wake;
        for (int i = 0; i < sleepingSessionList.size(); i++) {
            sleep = sleepingSessionList.get(i).sleep.toLocalTime();
            wake = sleepingSessionList.get(i).wake.toLocalTime();
            chronotypeDefinition.define(sleep, wake);
        }
        //then
        Assertions.assertTrue("Жаворонок".equals(chronotypeDefinition.printDefinition()), "Ожидается хронотип Жаворонок");
    }

    @Test
    @DisplayName("Получение хронотипа 'Голубь', когда время засыпание было до 22, а время пробуждения — после 9:00")
    void testDefine_whenFallingSleepBefore22AndWakingUpAfter9_True() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        ChronotypeDefinition chronotypeDefinition = new ChronotypeDefinition();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 21, 0), LocalDateTime.of(2026, 1, 1, 12, 0), SleepQuality.GOOD));
        //when
        LocalTime sleep;
        LocalTime wake;
        for (int i = 0; i < sleepingSessionList.size(); i++) {
            sleep = sleepingSessionList.get(i).sleep.toLocalTime();
            wake = sleepingSessionList.get(i).wake.toLocalTime();
            chronotypeDefinition.define(sleep, wake);
        }
        //then
        Assertions.assertTrue("Голубь".equals(chronotypeDefinition.printDefinition()), "Ожидается хронотип Голубь");
    }

    @Test
    @DisplayName("Получение хронотипа 'Голубь', когда засыпание было после 23:00, а время пробуждения до — 7:00")
    void testDefine_whenFallingSleepAfter23AndWakingUpBefore9_True() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        ChronotypeDefinition chronotypeDefinition = new ChronotypeDefinition();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 23, 1), LocalDateTime.of(2026, 1, 1, 5, 0), SleepQuality.GOOD));
        //when
        LocalTime sleep;
        LocalTime wake;
        for (int i = 0; i < sleepingSessionList.size(); i++) {
            sleep = sleepingSessionList.get(i).sleep.toLocalTime();
            wake = sleepingSessionList.get(i).wake.toLocalTime();
            chronotypeDefinition.define(sleep, wake);
        }
        //then
        Assertions.assertTrue("Голубь".equals(chronotypeDefinition.printDefinition()), "Ожидается хронотип Голубь");
    }
}
