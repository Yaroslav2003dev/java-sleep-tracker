package ru.yandex.practicum.sleeptracker;


import java.time.LocalTime;

import java.util.List;
import java.util.function.Function;

public class AmountNights implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessionsList) {

        long nightSession = sleepingSessionsList.stream()
                .filter(ss -> ss.sleep.toLocalDate().isBefore(ss.wake.toLocalDate()) || !ss.sleep.toLocalTime().isAfter(LocalTime.of(6, 0)))
                .map(ss -> ss.wake.toLocalDate())
                .distinct()
                .count();

        return new SleepAnalysisResult("Количество ночей: ", nightSession);

    }

}
