package ru.yandex.practicum.sleeptracker;


public class SleepAnalysisResult {
    String description;
    long value;
    String userType = "";


    public SleepAnalysisResult(String description, long value) {
        this.description = description;
        this.value = value;
    }

    public SleepAnalysisResult(String description, String userType) {
        this.description = description;
        this.userType = userType;
    }

    @Override
    public String toString() {
        if (userType.isBlank()) {
            return description + " " + value;
        } else {
            return description + " " + userType;
        }
    }
}
