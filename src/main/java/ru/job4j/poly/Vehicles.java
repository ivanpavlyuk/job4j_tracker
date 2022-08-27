package ru.job4j.poly;

public class Vehicles {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Autobus();
        Vehicle train = new Train();
        Vehicle[] vehicles = {plane, bus, train};
        for (Vehicle vehicle:vehicles) {
            vehicle.move();
        }
    }
}
