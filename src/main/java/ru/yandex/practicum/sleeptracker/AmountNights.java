package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AmountNights {

    public static int getAmountNights(List<SleepingSession> sleepingSessionList, ChronotypeDefinition chronotypeDefinition) {
        int countSleep = 0;
        LocalDate currentDateNight = null;
        for (SleepingSession sleepingSession : sleepingSessionList) {
            if (!sleepingSession.wake.toLocalDate().equals(currentDateNight) && (sleepingSession.sleep.toLocalDate().isBefore(sleepingSession.wake.toLocalDate()) || (sleepingSession.sleep.toLocalTime().isBefore(LocalTime.of(7, 0)) || sleepingSession.sleep.toLocalTime().equals(LocalTime.of(7, 0))))) {
                countSleep++;
                chronotypeDefinition.define(sleepingSession.sleep.toLocalTime(), sleepingSession.wake.toLocalTime());
                currentDateNight = sleepingSession.wake.toLocalDate();
            }
        }
        return countSleep;
    }

}
