package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MaxDurationSleepSessionTest {
    @Test
    @DisplayName("Максимальная продолжительность сессии, когда сессии отсутствуют")
    void testApply_WhenNoExistSessions_0() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        MaxDurationSleepSession maxDurationSleepSession = new MaxDurationSleepSession();
        //when
        SleepAnalysisResult sleepAnalysisResult = maxDurationSleepSession.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(0, sleepAnalysisResult.value, "Ожидается 0 при отсутствии сессий");
    }

    @Test
    @DisplayName("Максимальная продолжительность сессии, когда присутствуют 3 сессии")
    void testApply_WhenExistThreeSessions_270() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        MaxDurationSleepSession maxDurationSleepSession = new MaxDurationSleepSession();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 3, 0), LocalDateTime.of(2026, 1, 1, 5, 34), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 2, 5, 0), LocalDateTime.of(2026, 1, 2, 9, 30), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 5, 3, 0), LocalDateTime.of(2026, 1, 5, 3, 31), SleepQuality.GOOD));
        //when
        SleepAnalysisResult sleepAnalysisResult = maxDurationSleepSession.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(270, sleepAnalysisResult.value, "Ожидается 270 мин");
    }
}
