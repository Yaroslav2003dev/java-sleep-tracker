package ru.yandex.practicum.sleeptracker;


public class SleepAnalysisResult {
    String description;
    long value;


    public SleepAnalysisResult(String description, long value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public String toString() {
        return description + " " + value;
    }
}
