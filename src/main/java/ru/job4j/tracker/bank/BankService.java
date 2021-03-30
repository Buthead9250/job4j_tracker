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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if(!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя по паспорту.
     * @param passport паспорт пользователя.
     * @return возвращает найденного пользователя.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Поиск пользователя по реквизитам.
     * @param passport паспорт пользователя.
     * @param requisite реквизиты счета пользователя.
     * @return возвращает найденный счет по искомым реквизитам.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> account = Optional.empty();
        if (user.isPresent()) {
            account = users.get(user.get())
                    .stream()
                    .filter(r -> r.getRequisite().equals(requisite))
                    .findFirst();
        }
        return account;
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && (srcAccount.get().getBalance() - amount) >= 0) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
