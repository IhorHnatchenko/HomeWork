package org.example.service;

import org.example.model.Reader;

import java.util.List;

public interface ReaderService {
    List<Reader> getAll();

    Reader getByLogin(String login);

    Reader create(Reader reader);
}
