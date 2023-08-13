package org.example.convertor;

import org.example.dto.UserDto;
import org.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvertorImpl implements UserConvertor {

    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getName(), user.getEmail());
    }

    @Override
    public User toEntity(UserDto userDto) {
        return new User(userDto.getName(), userDto.getEmail());
    }


}
