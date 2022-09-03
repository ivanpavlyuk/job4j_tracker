package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can not be empty.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password must have from 8 to 32 symbols.");
        }
        boolean isValid = false;
        for (int index = 0; index < password.length(); index++) {
            if (Character.isUpperCase(password.charAt(index))) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Password must have at least 1 upper case letter");
        }
        isValid = false;
        for (int index = 0; index < password.length(); index++) {
            if (Character.isLowerCase(password.charAt(index))) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Password must have at least 1 lower case letter");
        }
        isValid = false;
        for (int index = 0; index < password.length(); index++) {
            if (Character.isDigit(password.charAt(index))) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Password must have at least 1 number");
        }
        isValid = false;
        for (int index = 0; index < password.length(); index++) {
            if (!Character.isDigit(password.charAt(index))
                    && !Character.isLowerCase(password.charAt(index))
                    && !Character.isUpperCase(password.charAt(index))) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("Password must have at least 1 special symbol");
        }
        String duplicate = password.toLowerCase();
            if (duplicate.contains("qwerty")
                || duplicate.contains("12345")
                || duplicate.contains("password")
                || duplicate.contains("admin")
                || duplicate.contains("user")) {
            throw new IllegalArgumentException("Please no these words in any case: qwerty, 12345, password, admin, user.");
        }
        return password;
    }
}