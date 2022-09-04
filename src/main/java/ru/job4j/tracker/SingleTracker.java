package ru.job4j.tracker;

public class SingleTracker {

    private Tracker tracker = new Tracker();
    private static SingleTracker single = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (single == null) {
            single = new SingleTracker();
        }
        return single;
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }
}