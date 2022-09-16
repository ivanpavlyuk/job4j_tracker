package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
            users.get(user).add(account);
        }
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}