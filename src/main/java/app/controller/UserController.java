package app.controller;

import app.model.User;
import app.service.implementations.UserServicesImp;
import app.service.interfaces.UserServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserServices userService;

    public UserController(UserServicesImp userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> userList() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable int id) {
        return userService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        return userService.removeUserById(id);
    }
    /**
     * save a user in the data base
     * @param user new user in the data base
     * @return the user id for authenticate
     */
    @PostMapping(value = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createNewUser(@RequestBody User user){
        return userService.SignUp(user);
    }

}
