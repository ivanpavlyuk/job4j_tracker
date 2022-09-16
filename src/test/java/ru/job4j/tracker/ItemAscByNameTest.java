package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemAscByNameTest {

    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(new Item(1, "Laundry"),
                                         new Item(2, "Restaurant"),
                                         new Item(3, "Cleaning"));
        List<Item> expected = Arrays.asList(new Item(3, "Cleaning"),
                                            new Item(1, "Laundry"),
                                            new Item(2, "Restaurant"));
        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }
}