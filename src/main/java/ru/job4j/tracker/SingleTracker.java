package ru.job4j.tracker;

import java.util.Arrays;

public class SingleTracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private static SingleTracker tracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (tracker == null) {
            tracker = new SingleTracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item unit = items[index];
            if (unit.getName().equals(key)) {
                rsl[count] = unit;
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }
}