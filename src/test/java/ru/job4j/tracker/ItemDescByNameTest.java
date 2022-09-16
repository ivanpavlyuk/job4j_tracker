package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {

    @Test
    public void whenDescSort() {
        List<Item> items = Arrays.asList(new Item(1, "Laundry"),
                                         new Item(2, "Restaurant"),
                                         new Item(3, "Cleaning"));
        List<Item> expected = Arrays.asList(new Item(2, "Restaurant"),
                                            new Item(1, "Laundry"),
                                            new Item(3, "Cleaning"));
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);

    }
}