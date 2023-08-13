package org.example.controller;

import org.example.convertor.ProfileConvertor;
import org.example.dto.ProfileDto;
import org.example.service.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService profileService;

    private final ProfileConvertor profileConvertor;

    public ProfileController(ProfileService profileService, ProfileConvertor profileConvertor) {
        this.profileService = profileService;
        this.profileConvertor = profileConvertor;
    }

    @GetMapping
    public List<ProfileDto> getAll() {
        return profileService.getAll()
                .stream()
                .map(profileConvertor::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProfileDto getById(@PathVariable(name = "id") long id) {
        return profileConvertor.toDto(profileService.getById(id));
    }

    @PostMapping
    public ProfileDto add(@RequestBody ProfileDto profileDto) {
        return profileConvertor.toDto(profileService.add(profileConvertor.toEntity(profileDto)));
    }
}
