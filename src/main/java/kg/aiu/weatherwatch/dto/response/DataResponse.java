package kg.aiu.weatherwatch.dto.response;

import lombok.Builder;
import java.sql.Timestamp;

@Builder
public record DataResponse(
        Integer humidity,
        Integer temperature,
        Integer windSpeed,
        Timestamp registrationTime,
        Long sensorId
) {
}
