package org.example.service;

import org.example.entity.Profile;


import java.util.List;

public interface ProfileService {

    List<Profile> getAll();

    Profile getById(long id);

    Profile add(Profile userProfile);
}
