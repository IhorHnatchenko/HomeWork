package org.example.dto;

import lombok.*;
import org.example.entity.Profile;

@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class UserDto {

    private String name;

    private String email;
}
