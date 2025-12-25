package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AverageDurationSleepSessionTest {
    @Test
    @DisplayName("Средняя продолжительность сессии, когда сессии отсутствуют")
    void testApply_WhenNoExistSessions_0() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        AverageDurationSleepSession averageDurationSleepSession = new AverageDurationSleepSession();
        //when
        SleepAnalysisResult sleepAnalysisResult = averageDurationSleepSession.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(0, sleepAnalysisResult.value, "Ожидается 0 при отсутствии сессий");
    }

    @Test
    @DisplayName("Средняя продолжительность сессии, когда присутствуют 3 сессии")
    void testApply_WhenExistThreeSessions_140() {
        //given
        List<SleepingSession> sleepingSessionList = new ArrayList<>();
        AverageDurationSleepSession averageDurationSleepSession = new AverageDurationSleepSession();
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 1, 3, 0), LocalDateTime.of(2026, 1, 1, 5, 0), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 2, 5, 0), LocalDateTime.of(2026, 1, 2, 9, 30), SleepQuality.GOOD));
        sleepingSessionList.add(new SleepingSession(LocalDateTime.of(2026, 1, 5, 3, 0), LocalDateTime.of(2026, 1, 5, 3, 31), SleepQuality.GOOD));
        //when
        SleepAnalysisResult sleepAnalysisResult = averageDurationSleepSession.apply(sleepingSessionList);
        //then
        Assertions.assertEquals(140, sleepAnalysisResult.value, "Ожидается 140 мин, так как 421/3=140 с округлением");
    }
}
