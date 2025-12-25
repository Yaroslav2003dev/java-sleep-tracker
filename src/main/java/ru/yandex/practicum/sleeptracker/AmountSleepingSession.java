package ru.yandex.practicum.sleeptracker;


import java.util.List;
import java.util.function.Function;

public class AmountSleepingSession implements Function<List<SleepingSession>, SleepAnalysisResult> {
    @Override
    public SleepAnalysisResult apply(List<SleepingSession> listSleepingSession) {
        return new SleepAnalysisResult("Количество сна за весь период:", listSleepingSession.size());
    }

}
