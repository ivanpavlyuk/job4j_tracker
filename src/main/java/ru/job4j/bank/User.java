package ru.job4j.bank;

import java.util.Objects;

/** Класс описывает клиента бланка
 * @author IVAN PAVLIUK
 * @version 1.0
 */
public class User {
    /**
     * Номер паспорта клиента хранится в строке
     */
    private String passport;
    /**
     * ФИО клиента хранится в строке
     */
    private String username;

    /**
     * Конструктор принимает на вход номер паспорта и ФИО клиента
     * @param passport номер паспорта
     * @param username ФИО клиента
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return возвращает номер паспорта клиента
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход номер паспорта,
     * заменяет им текущий номер паспорта клиента
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return возвращает ФИО клиента
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает на вход ФИО,
     * заменяет им текущее ФИО клиента
     * @param username ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод проверяет на равенство двух клиентов,
     * сравнивая их по номеру паспорта
     * @param o клиент, с которым идет сравнение
     * @return возвращает true, если номера паспортов совпадают
     * возвращает false, если номера паспортов разные
     * или хотя бы один из объектов null
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает хэш-код объекта
     * @return целочисленное значение хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}