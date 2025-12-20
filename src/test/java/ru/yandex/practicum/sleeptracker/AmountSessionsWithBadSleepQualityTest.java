package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AmountSessionsWithBadSleepQualityTest {

    @Test
    @DisplayName("Количество сессий с плохим количеством сна, когда сессии отсутствуют")
    void testApply_WhenNoExistSessions_0() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        AmountSessionsWithBadSleepQuality amountSessionsWithBadSleepQuality = new AmountSessionsWithBadSleepQuality();
        //when
        SleepAnalysisResult sleepAnalysisResult = amountSessionsWithBadSleepQuality.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(0, sleepAnalysisResult.value, "Ожидается 0 при отсутствии сессий");
    }

    @Test
    @DisplayName("Количество сессий с плохим количеством сна, когда присутствуют 3 сессии")
    void testApply_WhenExistThreeSessions_1() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        AmountSessionsWithBadSleepQuality amountSessionsWithBadSleepQuality = new AmountSessionsWithBadSleepQuality();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 3, 0), LocalDateTime.of(2026, 1, 1, 5, 34), "GOOD"));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 2, 5, 0), LocalDateTime.of(2026, 1, 2, 9, 30), "BAD"));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 5, 3, 0), LocalDateTime.of(2026, 1, 5, 3, 31), "GOOD"));
        //when
        SleepAnalysisResult sleepAnalysisResult = amountSessionsWithBadSleepQuality.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(1, sleepAnalysisResult.value, "Ожидается 1 сессия с плохим качеством сна");
    }

}
