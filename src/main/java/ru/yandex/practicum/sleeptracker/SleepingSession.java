package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;

public class SleepingSession {
    LocalDateTime sleep;
    LocalDateTime wake;
    SleepQuality status;


    public SleepQuality getStatus() {
        return status;
    }

    public SleepingSession(LocalDateTime sleep, LocalDateTime wake, SleepQuality status) {
        this.sleep = sleep;
        this.wake = wake;
        this.status = status;
    }
}
