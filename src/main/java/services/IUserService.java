package services;

import models.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    List<User> getUsers();

    User updateUser(UUID id, User user);
    
    User saveUser(User user);

    User getUser(UUID id);

    void deleteUser(UUID id);
}
