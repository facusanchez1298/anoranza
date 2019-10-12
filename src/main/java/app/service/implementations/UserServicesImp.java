package app.service.implementations;


import app.excepciones.Classes.UserNullExeption;
import app.excepciones.ExceptionController;
import app.model.User;
import app.repository.DaoUser;
import app.service.interfaces.UserServices;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices {
  private final DaoUser dbUser;
  private final ExceptionController controller;


  public UserServicesImp(DaoUser dbUser, ExceptionController controller) {
    this.dbUser = dbUser;
    this.controller = controller;
  }
  /**
   * save a user in the data base
   * @param user new user in the data base
   * @return the user id for authenticate
   */
  @Override
  public String SignUp(User user) {
    if(user == null)
      throw new UserNullExeption("the user entered is not valid");
    dbUser.save(user);
    return String.valueOf(user.getId());
  }
  /**
   * find a user by him id
   * @param id user id
   * @return a particular id
   */
  @Override
  public User findById(int id) {
    Optional<User> user = dbUser.findById(id);
    if (user.isPresent()) return user.get();
    throw new UserNullExeption("the entered user id is not valid");
  }
  /**
   * return a user with the user name entered
   * @param userName user name for search
   * @return a user with the entered user name
   */
  @Override
  public User findByUserName( String userName) {
    Optional<User> user = dbUser.findByUserName(userName);
    if(user.isPresent()) return user.get();
    throw new UserNullExeption("the entered username is not valid");
  }
  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  @Override
  public List<User> findAll() {
    return dbUser.findAll();
  }
  /**
   * delete a product from the dbUser base
   * @param id user id to delete
   */
  @Override
  public ResponseEntity removeUserById(int id) {
    dbUser.deleteById(id);
    if(dbUser.findById(id).isPresent()) return ResponseEntity.status(200).build();
    return ResponseEntity.status(418).build();
  }
  /**
   * update a user in the dbUser base
   * @param userId user id from user to change
   * @param user new dbUser for the user
   */
  @Override
  public void updateUserById( int userId, User user) {
    controller.correctUser(user);
    User dbUser = this.dbUser.getOne(userId);
    controller.correctUser(dbUser);
    user.setId(dbUser.getId()); //set the new user id, have to have the same id
    dbUser = user;
    this.dbUser.save(dbUser);
  }
}
