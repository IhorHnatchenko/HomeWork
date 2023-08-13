package org.example.controller;

import org.example.service.TransferService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/{accountOneId}/{accountTwoId}/{amount}")
    public void transfer(
            @PathVariable("accountOneId") long accountOneId,
            @PathVariable("accountTwoId") long accountTwoId,
            @PathVariable("amount") int amount){
        try {
            transferService.transfer(accountOneId,accountTwoId, amount);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
