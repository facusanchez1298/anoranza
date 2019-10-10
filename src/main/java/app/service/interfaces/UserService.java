package app.service.interfaces;

import app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> userList();

    Optional<User> findOne(Long id);

    User addUser(User user);

    String deleteUser(Long id);
}
