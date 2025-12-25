package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class AmountSessionsWithBadSleepQuality implements Function<List<SleepingSession>, SleepAnalysisResult> {
    Long countBadSleepingSession = 0L;

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        countBadSleepingSession = sleepingSessions
                .stream()
                .filter(ss -> ss.getStatus()==SleepQuality.BAD)
                .count();
        return new SleepAnalysisResult("Количество сессий с плохим качество сна:", countBadSleepingSession);
    }

}
