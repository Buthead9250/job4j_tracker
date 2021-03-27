package ru.job4j.tracker.bank;

import java.util.*;

public class BankService {
    /**
     * Банковский сервис по осуществлению денежных переводов
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового пользователя в систему.
     * Параметры метода: пользователи и список счетов.
     * @param user добавляемый пользователь.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Поиск пользователя по паспорту и получение списка его счетов.
     * Метод добавляет новый счет к существующему пользователю.
     * @param passport паспорт пользователя.
     * @param account список счетов.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя по паспорту.
     * @param passport паспорт пользователя.
     * @return возвращает найденного пользователя.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Поиск пользователя по реквизитам.
     * @param passport паспорт пользователя.
     * @param requisite реквизиты счета пользователя.
     * @return возвращает найденный счет по искомым реквизитам.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(r -> r.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег с одного счета на другой.
     * @param srcPassport паспорт отправителя денежных средств.
     * @param srcRequisite реквизиты счета отправителя денежных средств.
     * @param destPassport паспорт получателя денежных средств.
     * @param destRequisite реквизиты счета получателя денежных средств.
     * @param amount сумма средств на счете получателя после перечисления.
     * @return если счет не найден или на счете srcAccount отсутствует
     * необходимая для перевода сумма, то метод возвращает false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && (srcAccount.getBalance() - amount) >= 0) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
