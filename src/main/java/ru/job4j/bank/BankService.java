package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы,
 * которая позволяет совершать операции
 * над счетами клиентов банка
 * @author IVAN PAVLIUK
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о клиентах и их счетах
     * осуществляется в коллекции типа HashMap
      */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента, и,
     * если его еще нет в системе, добавляет его, создавая
     * для него новый счет
     * @param user клиент, которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер паспорта и банковский счет,
     * если клиент с таким паспортом есть в системе, проверяет,
     * есть ли у него уже данный счет,
     * если такого счета еще нет, создает его
     * @param passport номер паспорта клиента
     * @param account счет, который нужно создать
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод принимает на вход номер паспорта, и проверяет,
     * есть ли клиент с таким паспортом в системе,
     * если есть, возвращает этого клиента,
     * если нет, возвращает null
     * @param passport номер паспорта
     * @return возвращает клиента или null, если клиент не найден
     */
    public User findByPassport(String passport) {
        User found = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                found = user;
                break;
            }
        }
        return found;
    }

    /**
     * Метод принимает на вход номер паспорта и номер банковского счета,
     * если клиент с таким паспортом есть в системе, метод ищет
     * в списке счетов клиента тот,который соответствует номеру счета на входе,
     * если счет найден, возвращает его,
     * если нет - возвращает null.
     * @param passport номер паспорта
     * @param requisite номер банковского счета
     * @return возвращает банковский счет или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User found = findByPassport(passport);
        if (found != null) {
            List<Account> list = getAccounts(found);
            for (Account account : list) {
                if (requisite.equals(account.getRequisite())) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод получает на вход данные одного счета(номер паспорта и номер счета),
     * данные второго счета и сумму денег для перевода с первого счета на второй
     * @param srcPassport номер паспорта клиента, со счета которого произойдет списание суммы денег
     * @param srcRequisite номер счета, с которого производится списание суммы денег
     * @param destPassport номер паспорта клиента, на счет которого произойдет зачисление суммы денег
     * @param destRequisite номер счета, на который произойдет зачисление суммы денег
     * @param amount сумма денег
     * @return возвращает true, если перевод произведен успешно,
     * возвращает false, если счет не найден или на счете недостаточно средств
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод принимает на вход клиента и возвращает список его аккаунтов
     * @param user клиент
     * @return возвращает список счетов клиента,
     * возвращает null, если у клиента нет счетов.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}