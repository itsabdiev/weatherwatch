package kg.aiu.weatherwatch.dto.request;

import kg.aiu.weatherwatch.entity.enums.SensorStatus;
import lombok.Builder;
import java.util.Date;

@Builder
public record SensorRequest (
        String model,
        Date installationDate,
        SensorStatus status
) {
}
