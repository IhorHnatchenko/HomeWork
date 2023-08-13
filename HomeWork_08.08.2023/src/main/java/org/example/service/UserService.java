package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(long id);

    User add(User user);
}
