package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item date = new Item();
        LocalDateTime currentDate = date.getCreated();
        System.out.println(currentDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateFormat = currentDate.format(formatter);
        System.out.println(currentDateFormat);
    }
}
