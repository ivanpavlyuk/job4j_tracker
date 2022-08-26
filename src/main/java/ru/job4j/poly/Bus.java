package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("I'm driving...");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println(passengers < 41 ? "Welcome!" : "I can't take more than 40.");
    }

    @Override
    public double fillFuel(double fuel) {
        return fuel * 47.54;
    }
}
