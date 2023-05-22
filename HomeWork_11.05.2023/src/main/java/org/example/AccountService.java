package org.example;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
class AccountService {
    private static final Pattern IBAN_PATTERN = Pattern.compile("[A-Z]{2}\\d{1,32}");
    private static final Pattern CODE_PATTERN = Pattern.compile("\\d{6}");
    private static final int MAX_RETRY_COUNT = 3;

    private final AccountData accountData;
    private final Scanner scanner;

    public AccountService() {
        accountData = new AccountData();
        scanner = new Scanner(System.in);
    }

    public void performTransactions() {
        int retryCount = 0;

        while (true) {
            try {
                System.out.print("Введите номер банковского счета (IBAN): ");
                String iban = scanner.nextLine();

                if (!isValidIban(iban)) {
                    throw new IncorrectIbanNumber("Некорректный номер счета: " + iban);
                }

                Account account = accountData.getAccount(iban);

                if (account == null) {
                    throw new IncorrectIbanNumber("Некорректный номер счета: " + iban);
                }

                System.out.print("Введите код подтверждения: ");
                String code = scanner.nextLine();

                if (!isValidCode(code)) {
                    throw new IncorrectCodeNTemplate("Некорректный код: " + code);
                }


                if (!isCorrectAccessCode(iban, code)) {
                    throw new WrongAccessCode("Неверный код доступа");
                }

                System.out.println("Транзакция успешно выполнена.");
                showMenu(account);
                break;
            } catch (IncorrectIbanNumber e) {
                handleInvalidInput(e);
            } catch (IncorrectCodeNTemplate | WrongAccessCode e) {
                retryCount++;
                if (retryCount >= MAX_RETRY_COUNT) {
                    System.out.println("Превышено максимальное количество попыток. Работа программы завершена.");
                    break;
                }
                handleInvalidInput(e);
            }
        }
    }

    private void handleInvalidInput(Exception e) {
        System.out.println("Ошибка: " + e.getMessage());

        System.out.print("Желаете повторить ввод? (y/n): ");
        String choice = scanner.nextLine();

        if (!choice.equalsIgnoreCase("y")) {
            System.out.println("Работа программы завершена.");
            System.exit(0);
        }
    }

    private boolean isValidIban(String iban) {
        return IBAN_PATTERN.matcher(iban).matches();
    }

    private boolean isValidCode(String code) {
        return CODE_PATTERN.matcher(code).matches();
    }

    private boolean isCorrectAccessCode(String iban, String code) {
        Account account = accountData.getAccount(iban);
        return account != null && account.getName().equals("Account1") && accountData.getAccount("AT483200000012345864").getBalance() > 0
                && accountData.getAccount("AZ000000001234567890").getBalance() > 0 && accountData.getAccount("AZ000000001234567890").getName().equals("Account2");
    }

    private void showMenu(Account account) {
        while (true) {
            System.out.println("\n--- Меню операций ---");
            System.out.println("1. Перевод со счета");
            System.out.println("2. Перевод на счет");
            System.out.println("3. Показать баланс");
            System.out.println("4. Выйти");

            System.out.print("Выберите пункт меню: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    transferFromAccount(account);
                    break;
                case 2:
                    transferToAccount(account);
                    break;
                case 3:
                    showBalance(account);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Некорректный пункт меню. Повторите выбор.");
            }
        }
    }

    private void transferFromAccount(Account account) {
        System.out.print("Введите сумму для перевода: ");
        double amount = Double.parseDouble(scanner.nextLine());

        try {
            account.transferTo(accountData.getAccount("AZ000000001234567890"), amount);
            System.out.println("Перевод успешно выполнен.");
        } catch (NotEnoughFunds | TransferLimitException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Это не работает.
    private void transferToAccount(Account account) {
        System.out.print("Введите сумму для перевода: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Account sourceAccount = account;
        Account destinationAccount = accountData.getAccount("AT483200000012345864");

        if (account.getName().equals("Account1")) {
            sourceAccount = accountData.getAccount("AZ000000001234567890");
            destinationAccount = accountData.getAccount("AT483200000012345864");
        }

        if (sourceAccount != null && destinationAccount != null) {
            try {
                sourceAccount.transferTo(destinationAccount, amount);
                accountData.updateAccountBalance(getAccountIBAN(sourceAccount), sourceAccount.getBalance());
                accountData.updateAccountBalance(getAccountIBAN(destinationAccount), destinationAccount.getBalance());
                System.out.println("Перевод успешно выполнен.");
            } catch (NotEnoughFunds | TransferLimitException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } else {
            System.out.println("Ошибка: Некорректный счет для перевода.");
        }
    }

    private String getAccountIBAN(Account account) {
        for (Map.Entry<String, Account> entry : accountData.getAccounts().entrySet()) {
            if (entry.getValue() == account) {
                return entry.getKey();
            }
        }
        return null;
    }
    private void showBalance(Account account) {
        Account account1 = accountData.getAccount("AT483200000012345864");
        Account account2 = accountData.getAccount("AZ000000001234567890");
        System.out.println("Баланс на счете " + account1.getName() + ": " + account1.getBalance());
        System.out.println("Баланс на счете " + account2.getName() + ": " + account2.getBalance());
    }
}