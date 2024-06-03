package kg.aiu.weatherwatch.dto.response;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String access_token,
        String refresh_token
) {
}
