package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MinDurationSleepSessionTest {
    @Test
    @DisplayName("Минимальная продолжительность сессии, когда сессии отсутствуют")
    void testApply_WhenNoExistSessions_0() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        MinDurationSleepSession minDurationSleepSession = new MinDurationSleepSession();
        //when
        SleepAnalysisResult sleepAnalysisResult = minDurationSleepSession.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(0, sleepAnalysisResult.value, "Ожидается 0 при отсутствии сессий");
    }

    @Test
    @DisplayName("Минимальная продолжительность сессии, когда присутствуют 3 сессии")
    void testApply_WhenExistThreeSessions_30() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        MinDurationSleepSession minDurationSleepSession = new MinDurationSleepSession();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 01, 01, 03, 00), LocalDateTime.of(2026, 01, 01, 05, 00), "GOOD"));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 01, 02, 05, 00), LocalDateTime.of(2026, 01, 02, 05, 30), "GOOD"));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 01, 05, 03, 00), LocalDateTime.of(2026, 01, 05, 03, 31), "GOOD"));
        //when
        SleepAnalysisResult sleepAnalysisResult = minDurationSleepSession.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(30, sleepAnalysisResult.value, "Ожидается 30 мин");
    }
}
