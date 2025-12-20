package ru.yandex.practicum.sleeptracker;


import java.time.LocalTime;

public class ChronotypeDefinition {
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

}
