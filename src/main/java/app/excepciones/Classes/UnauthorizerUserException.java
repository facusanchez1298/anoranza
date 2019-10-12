package app.excepciones.Classes;

public class UnauthorizerUserException extends RuntimeException {

  public UnauthorizerUserException(String message) {
    super(message);
  }
}
