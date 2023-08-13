package org.example.service;

public interface TransferService {

    void transfer(long accountOneId, long accountTwoId, int amount) throws IllegalAccessException;
}
