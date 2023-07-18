package org.example.repository;

import org.example.model.Reader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    private Map<String, Reader> readerMap = new HashMap<>();

    @PostConstruct
    private void init() {
        readerMap.put("RexBeer", new Reader("RexBeer", "12345", "Ihor", "Hnatchenko", 21));
    }

    @Override
    public List<Reader> getAll() {
        List<Reader> readers = new ArrayList<>(readerMap.values());
        return readers;
    }

    @Override
    public Reader getByLogin(String login) {
        return readerMap.get(login);
    }

    @Override
    public Reader create(Reader reader) {
        readerMap.put(reader.getLogin(), reader);
        return reader;
    }
}
