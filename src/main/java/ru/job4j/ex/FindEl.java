package ru.job4j.ex;

import java.util.Objects;

public class FindEl extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] elements = {"Ferrari", "Porsche", "Maserati", "Aston Martin"};
        String el = "Ford";
        try {
            new FindEl().indexOf(elements, el);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
