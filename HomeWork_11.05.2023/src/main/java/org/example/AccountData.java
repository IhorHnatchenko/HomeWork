package org.example;

import java.util.HashMap;
import java.util.Map;


class AccountData {

    public static final double TRANSFER_LIMIT = 500.0;
    private Map<String, Account> accounts;

    public AccountData() {
        accounts = new HashMap<>();
        // Добавьте счета и начальные балансы по своему усмотрению
        accounts.put("AT483200000012345864", new Account("Account1", 1000));
        accounts.put("AZ000000001234567890", new Account("Account2", 500));
    }

    public Account getAccount(String iban) {
        return accounts.get(iban);
    }

    public void updateAccountBalance(String iban, double newBalance) {
        Account account = accounts.get(iban);
        if (account != null) {
            account.setBalance(newBalance);
            System.out.println("Баланс счета " + iban + " успешно обновлен.");
        } else {
            System.out.println("Ошибка: Счет " + iban + " не найден.");
        }
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}