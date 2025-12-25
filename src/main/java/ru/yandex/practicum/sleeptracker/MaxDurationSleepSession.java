package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class MaxDurationSleepSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    long maxMinutes;

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        maxMinutes = sleepingSessions
                .stream()
                .map(ss -> (Duration.between(ss.sleep, ss.wake).toMinutes()))
                .max(Long::compare)
                .orElse(0L);
        return new SleepAnalysisResult("Максимальная продолжительность сессии (в минутах):", maxMinutes);
    }

}
