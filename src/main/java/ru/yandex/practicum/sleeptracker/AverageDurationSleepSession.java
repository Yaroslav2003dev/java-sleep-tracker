package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class AverageDurationSleepSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    Double averageDuration = 0.0;

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        averageDuration = sleepingSessions
                .stream()
                .mapToLong(ss -> (Duration.between(ss.sleep, ss.wake).toMinutes()))
                .average().orElse(0.0);
        return new SleepAnalysisResult("Средняя продолжительность сессии (в минутах):", averageDuration.longValue());
    }

}
