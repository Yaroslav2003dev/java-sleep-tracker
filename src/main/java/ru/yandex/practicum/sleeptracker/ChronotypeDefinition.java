package ru.yandex.practicum.sleeptracker;


import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;

public class ChronotypeDefinition implements Function<List<SleepingSession>, SleepAnalysisResult> {
    int countOwl = 0;
    int countLark = 0;
    int countDove = 0;

    public void define(LocalTime sleep, LocalTime wake) {
        if (sleep.isAfter(LocalTime.of(23, 00)) && wake.isAfter(LocalTime.of(9, 00))) {
            countOwl++;
        } else if (sleep.isBefore(LocalTime.of(22, 00)) && wake.isBefore(LocalTime.of(7, 00))) {
            countLark++;
        } else {
            countDove++;
        }
    }

    public String printDefinition() {
        if (countOwl > countLark & countOwl > countDove) {
            return "Сова";
        } else if (countLark > countOwl & countLark > countDove) {
            return "Жаворонок";
        } else {
            return "Голубь";
        }
    }

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {

        sleepingSessions.stream()
                .filter(ss -> ss.sleep.toLocalDate().isBefore(ss.wake.toLocalDate()) || !ss.sleep.toLocalTime().isAfter(LocalTime.of(6, 0)))
                .map(ss -> ss.wake.toLocalDate())
                .distinct()
                .forEach(night -> {
                    sleepingSessions.stream()
                            .filter(ss -> ss.wake.toLocalDate().equals(night)
                                    && !ss.sleep.toLocalTime().isAfter(LocalTime.of(6, 0)))
                            .findFirst()
                            .ifPresent(ss -> define(ss.sleep.toLocalTime(), ss.wake.toLocalTime()));
                });


        return new SleepAnalysisResult("Хронотип: ", printDefinition());
    }
}
