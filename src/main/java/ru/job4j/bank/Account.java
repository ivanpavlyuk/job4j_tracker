package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счет
 * @author IVAN  PAVLIUK
 * @version 1.0
 */
public class Account {
    /**
     * Номер счета хранится в строке
     */
    private String requisite;
    /**
     * Количество денежных средств на счете хранится в переменной типа double
     */
    private double balance;

    /**
     * Конструктор принимает на вход номер счета и
     * количество денежных средств
     * @param requisite номер счета
     * @param balance количество денежных средств
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод-геттер для получения номера счета
     * @return возвращает номер счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход номер счета
     * и заменяет им текущий номер счета
     * @param requisite номер счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод-геттер для получения баланса на счете
     * @return возвращает количество денежных средств на счете
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход количество денежных средств
     * и заменяет им текущий баланс на счете
     * @param balance количество денег
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод проверяет на равенство два банковских счета,
     * сравнивая их номера
     * @param o номер счета для сравнения
     * @return возвращает true, если номера счетов совпадают,
     * возвращает false, если номера счетов разные
     * или один из счетов null
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хэш-код объекта
     * @return целочисленное значение хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}