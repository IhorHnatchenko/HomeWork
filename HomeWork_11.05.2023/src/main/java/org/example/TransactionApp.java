package org.example;

public class TransactionApp {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.performTransactions();
    }
}
