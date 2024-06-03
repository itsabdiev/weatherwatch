package kg.aiu.weatherwatch.dto.request;


import lombok.Builder;

@Builder
public record UserUpdateRequest(
        String phoneNumber,
        String firstName,
        String lastName
) {
}
