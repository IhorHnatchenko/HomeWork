package org.example;

class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void transferTo(Account destinationAccount, double amount) throws NotEnoughFunds, TransferLimitException {
        if (balance >= amount) {
            if (amount <= AccountData.TRANSFER_LIMIT) {
                balance -= amount;
                destinationAccount.balance += amount;
            } else {
                throw new TransferLimitException("Превышен лимит перевода: " + AccountData.TRANSFER_LIMIT);
            }
        } else {
            throw new NotEnoughFunds("Недостаточно средств на счете");
        }
    }
}
