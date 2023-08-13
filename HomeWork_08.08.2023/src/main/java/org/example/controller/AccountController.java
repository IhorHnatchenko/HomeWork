package org.example.controller;


import org.example.convertor.AccountConvertor;
import org.example.dto.AccountDto;
import org.example.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    private final AccountConvertor accountConvertor;

    public AccountController(AccountService accountService, AccountConvertor accountConvertor) {
        this.accountService = accountService;
        this.accountConvertor = accountConvertor;
    }

    @GetMapping
    public List<AccountDto> getAll() {
        return accountService.getAll()
                .stream()
                .map(accountConvertor::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable(name = "id") long id) {
        return accountConvertor.toDto(accountService.getById(id));
    }

    @PostMapping
    public AccountDto add(@RequestBody AccountDto accountDto) {
        return accountConvertor.toDto(accountService.add(accountConvertor.toEntity(accountDto)));
    }
}
