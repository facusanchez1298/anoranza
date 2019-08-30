package app.service.impl;

import app.model.User;
import app.repository.UserRepository;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "{'message' : 'User deleted succesfully.'}";
    }
}
