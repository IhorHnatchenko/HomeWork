package org.example.service;

import org.example.entity.Account;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    private final AccountService accountService;

    public TransferServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void transfer(long accountOneId, long accountTwoId, int amount) throws IllegalAccessException {
        Account accountOne = accountService.getById(accountOneId);
        Account accountTwo = accountService.getById(accountTwoId);

        if (accountOne.getAmount() - amount < 0) {
            throw new IllegalAccessException("Not enough amount on account.");
        }

        accountOne.setAmount(accountOne.getAmount() - amount);
        accountService.add(accountOne);

        accountTwo.setAmount(accountTwo.getAmount() + amount);
        accountService.add(accountTwo);
    }
}
