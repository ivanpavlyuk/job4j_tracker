package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student vasya = new Student();
        vasya.setName("Vasiliy Sidorovitch Pupkin");
        vasya.setGroup(5);
        vasya.setDate(new Date());
        System.out.println(vasya.getName() + " is learning Java in the group № "
                + vasya.getGroup() + " since " + vasya.getDate());
    }
}
