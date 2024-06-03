package kg.aiu.weatherwatch.dto.request;

import lombok.Builder;

@Builder
public record SignUpRequest(
        String email,
        String password,
        String phoneNumber,
        String firstName,
        String lastName
) {
}
