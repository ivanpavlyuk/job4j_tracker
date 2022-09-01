package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {

    @Test
    public void whenArgIsMinus1ThenThrowException() {
        int n = -1;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }

    @Test
    public void whenArgIs3ThenFactIs6() {
        int n = 3;
        int expected = 6;
        int rsl = new Fact().calc(3);
        assertThat(rsl).isEqualTo(expected);
    }
}