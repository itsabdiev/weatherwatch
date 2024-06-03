package kg.aiu.weatherwatch.exception;

import io.jsonwebtoken.JwtException;
import kg.aiu.weatherwatch.dto.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponse usernameNotFoundExceptionHandling(UsernameNotFoundException e) {
        return MessageResponse.builder()
                .statusCode(404)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(JwtException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public MessageResponse jwtExceptionHandling(JwtException e) {
        return MessageResponse.builder()
                .statusCode(403)
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponse notFoundExceptionHandling(NotFoundException re) {
        return MessageResponse.builder()
                .statusCode(404)
                .message(re.getMessage())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageResponse badRequestExceptionHandling(BadRequestException bre) {
        return MessageResponse.builder()
                .statusCode(400)
                .message(bre.getMessage())
                .build();
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageResponse userAlreadyExistExceptionHandling(UserAlreadyExistException uaee) {
        return MessageResponse.builder()
                .statusCode(400)
                .message(uaee.getMessage())
                .build();
    }
}
