package ru.job4j.poly;

public class Vehicles {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle[] vehicles = {bus, plane, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
