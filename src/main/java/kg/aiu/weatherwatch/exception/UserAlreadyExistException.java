package kg.aiu.weatherwatch.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super("User already exists");
    }
}
