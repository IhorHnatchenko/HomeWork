package org.example.convertor;

import org.example.dto.ProfileDto;
import org.example.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileConvertorImpl implements ProfileConvertor {

    @Override
    public ProfileDto toDto(Profile userProfile) {
        return new ProfileDto(userProfile.getProfile());
    }

    @Override
    public Profile toEntity(ProfileDto profileDto) {
        return new Profile(profileDto.getProfile());
    }
}
