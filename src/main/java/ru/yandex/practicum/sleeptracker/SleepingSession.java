package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;

public class SleepingSession {
    LocalDateTime sleep;
    LocalDateTime wake;
    String status;


    public String getStatus() {
        return status;
    }

    public SleepingSession(LocalDateTime sleep, LocalDateTime wake, String status) {
        this.sleep = sleep;
        this.wake = wake;
        this.status = status;
    }
}
