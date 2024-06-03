package kg.aiu.weatherwatch.endpoint;


import kg.aiu.weatherwatch.dto.request.UserUpdateRequest;
import kg.aiu.weatherwatch.dto.response.MessageResponse;
import kg.aiu.weatherwatch.entity.User;
import kg.aiu.weatherwatch.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserEndpoint {

    UserService userService;

    public MessageResponse update(UserUpdateRequest userUpdateRequest,String email) {
        User loadUserByEmail = userService.loadUserByEmail(email);
        loadUserByEmail.setFirstName(userUpdateRequest.firstName());
        loadUserByEmail.setPhoneNumber(userUpdateRequest.phoneNumber());
        loadUserByEmail.setLastName(userUpdateRequest.lastName());

        userService.save(loadUserByEmail);

        return MessageResponse.builder()
                .message("User has been updated")
                .statusCode(200)
                .build();
    }

    public MessageResponse delete(String username) {

        User user = userService.loadUserByEmail(username);

        userService.delete(user.getUsername());

        return MessageResponse.builder()
                .message("User has been deleted")
                .statusCode(200)
                .build();
    }
}
