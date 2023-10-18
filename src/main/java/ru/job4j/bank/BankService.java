package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает доступные операции банковской системы
 * @version 1.0
 */
public class BankService {

    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод добавляет пользователя в систему, если он в ней отсутствует
     * @param user пользователь, которого нужно добавить в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Этот метод удаляет пользователя из системы
     * @param passport по номеру паспорта идентифицируется пользователь, которого необходимо удалить
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Этот метод добавляет новый счет к пользователю
     * @param passport по номеру паспорта осуществляется поиск пользователя
     * @param account добавляем счет, если его нет у пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Этот метод ищет пользователя по номеру паспорта
     * @param passport по номеру паспорту осуществляется поиск
     * @return метод вернет null в случае, если пользователя нет в системе
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Этот метод ищет счет пользователя по реквизитам
     * @param passport ищем пользователя по номеру паспорта
     * @param requisite ищем счет по реквизитам
     * @return метод вернет null, если у пользователя такой счет отсутствует
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Этот метод позваляет перечислять деньги с одного счета на другой
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount сумма перевода
     * @return метод вернет true в случае, если перевод успешен, false - если перевод не удался
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (destAccount != null && srcAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
            return users.get(user);
        }
    }