package com.marcin.photo_studio.mapper;

import com.marcin.photo_studio.domain.user.User;
import com.marcin.photo_studio.domain.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getLogin(), userDto.getPassword());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getIsAdmin()
        );
    }

    public List<UserDto> mapToUserDto(final List<User> userList) {
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
