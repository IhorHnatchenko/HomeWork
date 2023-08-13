package org.example.controller;

import org.example.convertor.UserConvertor;
import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final UserConvertor userConvertor;


    public UserController(UserService userService, UserConvertor userConvertor) {
        this.userService = userService;
        this.userConvertor = userConvertor;
    }


    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll()
                .stream()
                .map(userConvertor::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") long id) {
        return userConvertor.toDto(userService.getById(id));
    }

    @PostMapping
    public UserDto add(@RequestBody UserDto userDto) {
        return userConvertor.toDto(userService.add(userConvertor.toEntity(userDto)));
    }
}
