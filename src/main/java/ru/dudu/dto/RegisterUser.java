package ru.dudu.dto;

import lombok.Data;
import ru.dudu.model.UserAccaunt;

@Data
public class RegisterUser {
    private String login;
    private String password;
    private String email;
}
