package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_base")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotBlank(message = "Field name is mandatory.")
    private String name;

    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profileId", referencedColumnName = "id")
    private Profile profile;

/*  SELECT USER_BASE.ID, USER_BASE.NAME, USER_BASE.PROFILE_ID, PROFILE.ID, PROFILE.PROFILE
        FROM USER_BASE
        LEFT JOIN PROFILE ON USER_BASE.ID = PROFILE.ID
            */

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Account> accounts = new ArrayList<>();

/*  SELECT USER_BASE.ID, USER_BASE.NAME, ACCOUNT_DB.ID, ACCOUNT_DB.AMOUNT, ACCOUNT_DB.USER_ID
        FROM USER_BASE
        LEFT JOIN ACCOUNT_DB ON USER_BASE.ID = ACCOUNT_DB.USER_ID;
            */


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
