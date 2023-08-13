package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "account_db")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String iban;

    private long amount;

    public Account(String name, String iban, long amount) {
        this.name = name;
        this.iban = iban;
        this.amount = amount;
    }

/*    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;*/


}
