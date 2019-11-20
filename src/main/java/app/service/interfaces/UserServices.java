package app.service.interfaces;

import app.model.User;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserServices extends UserDetailsService {
  /**
   * save a user in the data base
   * @param user new user in the data base
   * @return the user id for authenticate
   */
  String SignUp(User user);
  /**
   * return a particular user from the data base
   * @param id user id
   * @return a particular user
   */
  User findById( int id);
  /**
   * return a user with the user name entered
   * @param userName user name for search
   * @return a user with the entered user name
   */
  User findByUserName( String userName);
  /**
   * return all the users in the database
   * @return all the users in the dataBase
   */
  List<User> findAll();
  /**
   * dele a user from the data base
   * @param id user id to delete
   */
  ResponseEntity removeUserById( int id);
  /**
   *  edit a user in the data base
   * @param id user id for update
   * @param user new data for update
   */
  void updateUserById( int id, User user);
  /**
   * add a product to the shopping cart
   * @param id user id
   * @param product product to add
   */

}
