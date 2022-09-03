package ru.job4j.early;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorTest {

    @Test
    public void whenPasswordIsNullThenThrowsException() {
        String password = null;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.validate(password));
        Assertions.assertEquals("Password can not be empty.", thrown.getMessage());
    }

    @Test
    public void whenPasswordIsWWWWWThrowsException() {
        String password = "WWWWW";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.validate(password));
        Assertions.assertEquals("Password must have from 8 to 32 symbols.", thrown.getMessage());
    }

    @Test
    public void whenPasswordIswwwwwwwwThrowsException() {
        String password = "wwwwwwww";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.validate(password));
        Assertions.assertEquals("Password must have at least 1 upper case letter", thrown.getMessage());
    }

    @Test
    public void whenPasswordIsWWWWWWWWThrowsException() {
        String password = "WWWWWWWW";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.validate(password));
        Assertions.assertEquals("Password must have at least 1 lower case letter", thrown.getMessage());
    }

    @Test
    public void whenPasswordIswWwwwwwwThrowsException() {
        String password = "wWwwwwww";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.validate(password));
        Assertions.assertEquals("Password must have at least 1 number", thrown.getMessage());
    }

    @Test
    public void whenPasswordIswW3wwwwwThrowsException() {
        String password = "wW3wwwww";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.validate(password));
        Assertions.assertEquals("Password must have at least 1 special symbol", thrown.getMessage());
    }

    @Test
    public void whenPasswordIswW3AmpersandqwertyThrowsException() {
        String password = "wW3&qwerty";
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> PasswordValidator.validate(password));
        Assertions.assertEquals("Please no these words in any case: qwerty, 12345, password, admin, user.", thrown.getMessage());
    }

    @Test
    public void whenPasswordIswW3AmpersandwertyIsValid() {
        String password = "wW3&werty";
        String expected = PasswordValidator.validate(password);
        assertThat(password).isEqualTo(expected);
    }

}