package kg.aiu.weatherwatch.dto.request;

public record AuthenticationRequest(
        String username,
        String password
) {
}
