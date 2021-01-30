package com.marcin.photo_studio.controller;

import com.marcin.photo_studio.domain.user.User;
import com.marcin.photo_studio.domain.user.UserDto;
import com.marcin.photo_studio.mapper.UserMapper;
import com.marcin.photo_studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getAllUsers() {
        return mapper.mapToUserDto(service.getAllUsers());
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public UserDto getUserById(@RequestParam Long userId) {
        return mapper.mapToUserDto(service.getUserById(userId));
    }
    @RequestMapping(method = RequestMethod.GET, value = "users/{login}")
    public UserDto getUserByLogin(@RequestParam String login) {
        return mapper.mapToUserDto(service.getUserByLogin(login));
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users/create", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.createUser(mapper.mapToUser(userDto));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/changeAccess")
    public UserDto changeUserAccess(@RequestParam Long userId) {
        return mapper.mapToUserDto(service.changeUserAccess(userId));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/changePassword")
    public UserDto changeUserPassword(@RequestParam Long userId, @RequestParam String newPassword) {
        return mapper.mapToUserDto(service.changeUserPassword(userId, newPassword));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser(@RequestParam Long userId) {
        service.deleteUser(userId);
    }
}
