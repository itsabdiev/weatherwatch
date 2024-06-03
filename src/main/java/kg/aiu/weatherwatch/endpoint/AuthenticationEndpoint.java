package kg.aiu.weatherwatch.endpoint;


import io.jsonwebtoken.JwtException;
import kg.aiu.weatherwatch.dto.request.AuthenticationRequest;
import kg.aiu.weatherwatch.dto.request.SignUpRequest;
import kg.aiu.weatherwatch.dto.response.AuthenticationResponse;
import kg.aiu.weatherwatch.dto.response.MessageResponse;
import kg.aiu.weatherwatch.entity.User;
import kg.aiu.weatherwatch.entity.enums.Role;
import kg.aiu.weatherwatch.exception.UserAlreadyExistException;
import kg.aiu.weatherwatch.security.util.JsonWebTokenService;
import kg.aiu.weatherwatch.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationEndpoint {

    AuthenticationManager authenticationManager;
    UserService userService;
    JsonWebTokenService jsonWebTokenService;
    PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        User user = userService.loadUserByEmail(request.username());
        String token = jsonWebTokenService.generateToken(user);
        String refreshToken = jsonWebTokenService.generateRefreshToken(user.getUsername());
        return AuthenticationResponse.builder()
                .access_token(token)
                .refresh_token(refreshToken)
                .build();
    }


    public AuthenticationResponse generateNewAccessAndRefreshTokenByRefreshToken(String refreshToken) {
        if (jsonWebTokenService.isTokenExpired(refreshToken)) {
            throw new JwtException("Refresh token has been expired");
        }
        String username = jsonWebTokenService.extractUsername(refreshToken);
        User user = userService.loadUserByEmail(username);
        return AuthenticationResponse.builder()
                .access_token(jsonWebTokenService.generateToken(user))
                .refresh_token(jsonWebTokenService.generateRefreshToken(username))
                .build();
    }

    public MessageResponse signUp(SignUpRequest signUpRequest) {

        if (userService.existsByEmail(signUpRequest.email())) {
            throw new UserAlreadyExistException();
        }

        User user = User.builder()
                .role(Role.USER)
                .username(signUpRequest.email())
                .firstName(signUpRequest.firstName())
                .lastName(signUpRequest.lastName())
                .phoneNumber(signUpRequest.phoneNumber())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .build();

        userService.save(user);

        return MessageResponse.builder()
                .message("User has been registered")
                .statusCode(201)
                .build();
    }


}
