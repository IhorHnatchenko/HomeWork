package org.example.convertor;

import org.example.dto.UserDto;
import org.example.entity.User;

public interface UserConvertor {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}
