package com.restik.mydiplom.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AppUser {

    @Size(min=2, max=30)
    private String login;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message="Пароль должен состоять из...")
    private String pwd;
}
