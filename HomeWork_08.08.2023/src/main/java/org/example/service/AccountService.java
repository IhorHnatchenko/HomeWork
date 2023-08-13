package org.example.service;

import org.example.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();

    Account getById(long id);

    Account add(Account account);
}
