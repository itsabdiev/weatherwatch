package kg.aiu.weatherwatch.dto.request;

import lombok.Builder;

import java.sql.Timestamp;

@Builder
public record AlertRequest(
        String warningMessage,
        Timestamp registrationTime,
        Long sensorId
) {

}
