package app.controller;

import app.model.User;
import app.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/test")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<User> userList() {
        return userService.userList();
    }

    @RequestMapping("/{id}")
    public Optional<User> findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @RequestMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }


}
