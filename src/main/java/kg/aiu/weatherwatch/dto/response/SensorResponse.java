package kg.aiu.weatherwatch.dto.response;

import kg.aiu.weatherwatch.entity.enums.SensorStatus;
import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Builder
public record SensorResponse (
        Long id,
        UUID sensorNumber,
        String model,
        Date installationDate,
        SensorStatus status
) {
}
