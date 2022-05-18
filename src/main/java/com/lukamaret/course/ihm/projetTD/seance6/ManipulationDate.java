package com.lukamaret.course.ihm.projetTD.seance6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManipulationDate {

    public String printDateTime() {
        return printDateTime(LocalDateTime.now());
    }

    private String printDateTime(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String addHours(int hours) {
        return printDateTime(LocalDateTime.now().plusHours(hours));
    }

    public String addDays(int days) {
        return printDateTime(LocalDateTime.now().plusDays(days));
    }

    public String duration(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        return String.format("%d h %02d min %02d sec", duration.toHours(), duration.toMinutes() % 60, duration.getSeconds() % 3600);
    }

}
