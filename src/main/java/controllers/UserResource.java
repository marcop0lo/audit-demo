package controllers;

import lombok.AllArgsConstructor;
import models.User;
import org.springframework.web.bind.annotation.*;
import services.IUserService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserResource {

    IUserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable UUID id){
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
    }
}
