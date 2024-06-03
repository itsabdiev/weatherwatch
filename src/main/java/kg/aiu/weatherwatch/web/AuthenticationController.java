package kg.aiu.weatherwatch.web;

import kg.aiu.weatherwatch.dto.request.AuthenticationRequest;
import kg.aiu.weatherwatch.dto.request.SignUpRequest;
import kg.aiu.weatherwatch.dto.response.AuthenticationResponse;
import kg.aiu.weatherwatch.dto.response.MessageResponse;
import kg.aiu.weatherwatch.endpoint.AuthenticationEndpoint;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationController {

    AuthenticationEndpoint authenticationEndpoint;

    @PostMapping ("/sign-in")
    public AuthenticationResponse signIn(@RequestBody AuthenticationRequest authenticationRequest) {
        return authenticationEndpoint.authenticate(authenticationRequest);
    }

    @PostMapping("/refresh-token")
    public AuthenticationResponse generateNewAccessAndRefreshTokenByRefreshToken(
            @RequestParam(name = "refresh_token") String refresh_token) {
        return authenticationEndpoint.generateNewAccessAndRefreshTokenByRefreshToken(refresh_token);
    }

    @PostMapping("/sign-up")
    public MessageResponse signUp(
            @RequestBody SignUpRequest signUpRequest) {
        return authenticationEndpoint.signUp(signUpRequest);
    }
}
