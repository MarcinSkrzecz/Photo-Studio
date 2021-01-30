package com.marcin.photo_studio.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private Boolean isAdmin;

    public UserDto(Long id, String login, String password, Boolean isAdmin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
