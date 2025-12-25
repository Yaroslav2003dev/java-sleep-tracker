package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MinDurationSleepSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    long minMinutes;

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        minMinutes = sleepingSessions
                .stream()
                .map(ss -> (Duration.between(ss.sleep, ss.wake).toMinutes()))
                .min(Long::compare)
                .orElse(0L);

        return new SleepAnalysisResult("Минимальная продолжительность сессии (в минутах):", minMinutes);
    }


}
