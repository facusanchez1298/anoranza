package app.excepciones;


import app.excepciones.Classes.UnauthorizerUserException;
import app.excepciones.Classes.UserNullExeption;
import app.model.User;
import app.repository.DaoUser;
import org.springframework.stereotype.Service;

@Service
public class ExceptionController {
  private final DaoUser dbUser;

  public ExceptionController(DaoUser dbUser) {
    this.dbUser = dbUser;
  }

  /**
   * launch a exception if the user id is null
   * @param userId user id for search
   */
  public void correctUser(int userId){
    if(!dbUser.findById(userId).isPresent())
      throw new UserNullExeption("the entered user id is not valid");
  }
  /**
   * launch a exception if the user is null
   * @param user user for search
   */
  public void correctUser(User user){
    if(user == null)
      throw new UserNullExeption("the id entered is not valid");
  }
  /**
   * compare the entered id with the id in data base
   * @param id user id from the header
   * @return true if the id is correct else return false
   */
  public void correctAuthorization(String id) {
    User user = dbUser.findById(Integer.parseInt(id)).get();
    if(user == null)
      throw new UnauthorizerUserException("401: you have to start session for continue");
  }
}
