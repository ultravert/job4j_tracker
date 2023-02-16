package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Чтобы начать движение нажмите на газ.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Вместимость автобуса " + passengers + " человек.");
    }

    @Override
    public double fill(double fuel) {
        double price = 100;
        return price * fuel;
    }
}
