package ru.dudu.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Data
public class UserAccaunt  extends BaseEntity{

    public enum AccountStatus { NEW, CONFIRMED, DELETED}

    @Column(unique = true)
    @NotNull
    String login;

    @Column(unique = true)
    @NotNull
    String email;

    @NotNull
    String password;

    @Column
    @Enumerated(EnumType.STRING)
    AccountStatus status;

    @Column
    String regCode;

    public UserAccaunt(@NotNull String login, @NotNull String email, @NotNull String password) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.status = AccountStatus.NEW;
        this.regCode = String.valueOf((int)(Math.random()*1000000));
    }
}
