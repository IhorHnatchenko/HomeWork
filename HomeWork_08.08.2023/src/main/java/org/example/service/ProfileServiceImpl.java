package org.example.service;

import org.example.entity.Profile;
import org.example.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getById(long id) {
        return profileRepository.getReferenceById(id);
    }

    @Override
    public Profile add(Profile userProfile) {
        return profileRepository.save(userProfile);
    }
}
