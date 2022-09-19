package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = Integer.compare(left.length(), right.length());
        int min = Math.min(left.length(), right.length());
        for (int index = 0; index < min; index++) {
            if (left.charAt(index) != right.charAt(index)) {
                rsl = Character.compare(left.charAt(index), right.charAt(index));
                break;
            }
        }
        return rsl;
    }
}