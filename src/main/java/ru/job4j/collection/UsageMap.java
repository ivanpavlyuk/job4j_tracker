package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        names.put("vasyapupkin@gmail.com", "Vasiliy Pupkin");
        names.put("vanyapokrishkin@yandex.ru", "Ivan Pokrishkin");
        names.put("jackricher@yahoo.com", "Jack Richer");
        for (String mail : names.keySet()) {
            String name = names.get(mail);
            System.out.println(mail + " = " + name);
        }
    }
}
