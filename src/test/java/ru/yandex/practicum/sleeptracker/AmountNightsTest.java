package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AmountNightsTest {
    @Test
    @DisplayName("Количество ночей, когда ночные сессии сна отсутствуют")
    void testGetAmountNights_WhenNoExistNightSessions_0() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 2, 9, 0), LocalDateTime.of(2026, 1, 2, 10, 30), SleepQuality.GOOD));
        AmountNights amountNight = new AmountNights();
        //when
        long count = amountNight.apply(sleepingSessionList).value;
        //then
        Assertions.assertEquals(0, count, "Ожидается 0 ночей");
    }

    @Test
    @DisplayName("Количество ночей, когда полностью отсутствуют сессии сна")
    void testGetAmountNights_WhenNoExistSessions_0() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        AmountNights amountNight = new AmountNights();
        //when
        long amountNights = amountNight.apply(sleepingSessionList).value;
        //then
        Assertions.assertEquals(0, amountNights, "Ожидается 0 ночей");
    }

    @Test
    @DisplayName("Количество ночей, когда есть только 1 ночная сессия сна среди 3 сессий")
    void testGetAmountNights_WhenExistOneNightSessions_1() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 1, 0), LocalDateTime.of(2026, 1, 2, 10, 30), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 3, 10, 0), LocalDateTime.of(2026, 1, 3, 10, 30), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 2, 12, 0), LocalDateTime.of(2026, 1, 2, 15, 30), SleepQuality.GOOD));
        AmountNights amountNight = new AmountNights();
        //when
        long amountNights = amountNight.apply(sleepingSessionList).value;
        //then
        Assertions.assertEquals(1, amountNights, "Ожидается 1 ночь");
    }

    @Test
    @DisplayName("Количество ночей, когда есть 3 ночных сессий сна")
    void testGetAmountNights_WhenExistThreeNightSessions_3() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 3, 0), LocalDateTime.of(2026, 1, 1, 5, 0), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 2, 5, 0), LocalDateTime.of(2026, 1, 2, 9, 30), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 5, 3, 0), LocalDateTime.of(2026, 1, 5, 3, 31), SleepQuality.GOOD));
        AmountNights amountNight = new AmountNights();
        //when
        long amountNights = amountNight.apply(sleepingSessionList).value;
        //then
        Assertions.assertEquals(3, amountNights, "Ожидается 3 ночи");
    }
}
