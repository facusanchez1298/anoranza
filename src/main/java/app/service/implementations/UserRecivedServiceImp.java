package app.service.implementations;

import app.excepciones.Classes.UserNullExeption;
import app.model.UserRecived;
import app.repository.UserRecivedRepository;
import app.service.interfaces.UserRecivedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRecivedServiceImp implements UserRecivedService {

    private UserRecivedRepository userRepository;

    @Autowired
    public UserRecivedServiceImp(UserRecivedRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserRecived> userList() {
        return userRepository.findAll();
    }

    @Override
    public UserRecived findOne(Long id) {
        Optional<UserRecived> userRecived = userRepository.findById(id);
        if (userRecived.isPresent()) return userRecived.get();
        throw new UserNullExeption("the entered user id is not valid");
    }

    @Override
    public UserRecived addUser(UserRecived user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "{'message' : 'UserRecived deleted succesfully.'}";
    }
}
