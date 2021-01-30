package com.marcin.photo_studio.service;

import com.marcin.photo_studio.domain.user.User;
import com.marcin.photo_studio.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(final Long userId) {
        if (repository.findById(userId).isPresent()) {
            return repository.findById(userId).get();
        } else throw new IllegalArgumentException("User not found");
    }

    public User getUserByLogin(final String login) {
         User dbRecord = getAllUsers().stream()
                .filter(l -> l.getLogin().equals(login))
                .collect(Collectors.toList()).get(0);

         if (dbRecord != null) {
             return dbRecord;
         } else throw new IllegalArgumentException("User not found");
    }

    public void createUser(final User user) {
        repository.save(user);
    }

    public User changeUserAccess(Long userId) {
        Optional<User> dbRecord = repository.findById(userId);

        if (dbRecord.isPresent()) {
            User userToUpdate = dbRecord.get();

            if (userToUpdate.getIsAdmin()) {
                userToUpdate.setIsAdmin(false);
            } else {
                userToUpdate.setIsAdmin(true);
            }

            repository.save(userToUpdate);
            return userToUpdate;
        } else throw new IllegalArgumentException("User not found");
    }

    public User changeUserPassword(Long userId, String newPassword) {
        Optional<User> dbRecord = repository.findById(userId);

        if (dbRecord.isPresent()) {
            User userToUpdate = dbRecord.get();

            userToUpdate.setPassword(newPassword);

            repository.save(userToUpdate);
            return userToUpdate;
        } else throw new IllegalArgumentException("User not found");
    }

    public void deleteUser(long userId) {
        repository.deleteById(userId);
    }
}