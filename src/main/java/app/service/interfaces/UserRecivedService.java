package app.service.interfaces;

import app.model.UserRecived;

import java.util.List;

public interface UserRecivedService {

    List<UserRecived> userList();

    UserRecived findOne(Long id);

    UserRecived addUser(UserRecived user);

    String deleteUser(Long id);
}
