package services;

import exceptions.UserNotFoundException;
import models.User;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService{

    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UUID id, User user){
        User existingUser = this.getUser(id);
        existingUser.setApellido(user.getApellido());
        existingUser.setNombre(user.getNombre());
        existingUser.setEdad(user.getEdad());
        existingUser.setPais(user.getPais());
        return userRepository.save(user);
    }

    @Override
    public User getUser(UUID id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }
}
