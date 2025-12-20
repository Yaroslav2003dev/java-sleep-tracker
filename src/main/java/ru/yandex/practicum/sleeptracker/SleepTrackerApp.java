package ru.yandex.practicum.sleeptracker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {

    public static void main(String[] args) {
        List<Function<List<SleepingSession>, SleepAnalysisResult>> sleepObjects = new ArrayList<>();
        ChronotypeDefinition chronotypeDefinition = new ChronotypeDefinition();
        AmountSleepingSession amountSleepingSession = new AmountSleepingSession();
        MinDurationSleepSession minDurationSleepSession = new MinDurationSleepSession();
        MaxDurationSleepSession maxDurationSleepSession = new MaxDurationSleepSession();
        AverageDurationSleepSession averageDurationSleepingSession = new AverageDurationSleepSession();
        AmountSessionsWithBadSleepQuality amountSessionsWithBadSleepQuality = new AmountSessionsWithBadSleepQuality();
        AmountNights amountNights = new AmountNights();
        sleepObjects.add(amountSleepingSession);
        sleepObjects.add(minDurationSleepSession);
        sleepObjects.add(maxDurationSleepSession);
        sleepObjects.add(averageDurationSleepingSession);
        sleepObjects.add(amountSessionsWithBadSleepQuality);
        sleepObjects.add(amountNights);
        sleepObjects.add(chronotypeDefinition);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

        try (FileReader reader = new FileReader("src/main/resources/sleep_log.txt")) {
            BufferedReader br = new BufferedReader(reader);

            List<SleepingSession> sleepingSessionList = br.lines()
                    .map(line -> line.split(";"))
                    .map(data -> new SleepingSession(LocalDateTime.parse(data[0], formatter),
                            LocalDateTime.parse(data[1], formatter),
                            data[2])).toList();

            sleepObjects.stream()
                    .map(object -> object.apply(sleepingSessionList))
                    .forEach(System.out::println);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}