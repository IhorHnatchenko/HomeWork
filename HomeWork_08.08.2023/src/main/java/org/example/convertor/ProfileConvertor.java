package org.example.convertor;

import org.example.dto.ProfileDto;
import org.example.entity.Profile;

public interface ProfileConvertor {

    ProfileDto toDto(Profile userProfile);

    Profile toEntity(ProfileDto profileDto);
}
