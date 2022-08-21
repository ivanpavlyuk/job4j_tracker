package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[this.size];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            Item unit = items[index];
            if (unit != null) {
                rsl[size] = unit;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
        }

    public Item[] findByName(String key) {
        Item[] rsl = Arrays.copyOf(items, size);
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            Item unit = items[index];
            if (unit.getName().equals(key)) {
                rsl[size] = unit;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}