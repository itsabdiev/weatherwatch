package kg.aiu.weatherwatch.dto.request;

import lombok.Builder;
import java.sql.Timestamp;

@Builder
public record DataRequest(
        Integer humidity,
        Integer temperature,
        Integer windSpeed,
        Timestamp registrationTime,
        Long sensorId
) {
}
