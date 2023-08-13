package org.example.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AccountDto {

    private String name;

    private String iban;

    private long amount;
}
