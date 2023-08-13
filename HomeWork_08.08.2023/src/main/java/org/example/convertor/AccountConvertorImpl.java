package org.example.convertor;

import org.example.dto.AccountDto;
import org.example.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountConvertorImpl implements AccountConvertor {

    @Override
    public AccountDto toDto(Account account) {
        return new AccountDto(account.getName(), account.getIban(), account.getAmount());
    }

    @Override
    public Account toEntity(AccountDto accountDto) {
        return new Account(accountDto.getName(), accountDto.getIban(), accountDto.getAmount());
    }
}
