package org.example.convertor;

import org.example.dto.AccountDto;
import org.example.entity.Account;

public interface AccountConvertor {

    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);
}
