package kg.aiu.weatherwatch.endpoint;


import kg.aiu.weatherwatch.dto.request.SensorRequest;
import kg.aiu.weatherwatch.dto.response.MessageResponse;
import kg.aiu.weatherwatch.dto.response.SensorResponse;
import kg.aiu.weatherwatch.entity.Sensor;
import kg.aiu.weatherwatch.exception.NotFoundException;
import kg.aiu.weatherwatch.exception.SensorAlreadyExistException;
import kg.aiu.weatherwatch.service.SensorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SensorEndpoint {

    SensorService sensorService;

    public MessageResponse save(SensorRequest sensorRequest) {
        if (sensorService.existsByModel(sensorRequest.model())) throw new SensorAlreadyExistException();
        sensorService.save(dtoToEntityMapper(sensorRequest));
        return MessageResponse.builder()
                .message("Sensor has been created")
                .statusCode(201)
                .build();
    }

    public MessageResponse update(Long id, SensorRequest sensorRequest) {
        existsByIdOrThrowException(id);
        Sensor sensor = dtoToEntityMapper(sensorRequest);
        sensor.setId(id);
        sensorService.save(sensor);
        return MessageResponse.builder()
                .message("Sensor has been updated")
                .statusCode(200)
                .build();

    }

    public MessageResponse delete(Long id) {
        existsByIdOrThrowException(id);
        sensorService.deleteById(id);
        return MessageResponse.builder()
                .message("Sensor has been removed")
                .statusCode(200)
                .build();

    }

    public SensorResponse getById(Long id) {
        existsByIdOrThrowException(id);
        return entityToDtoMapper(sensorService.getById(id));
    }

    public void existsByIdOrThrowException(Long id) {
        if (!sensorService.existsById(id)) throw new NotFoundException("Sensor has not been found");
    }

    public List<SensorResponse> getAll() {
        return sensorService.getAll().stream().map(this::entityToDtoMapper).collect(Collectors.toList());
    }

    private Sensor dtoToEntityMapper(SensorRequest sensorRequest) {
        return Sensor.builder()
                .sensorNumber(UUID.randomUUID())
                .model(sensorRequest.model())
                .installationDate(sensorRequest.installationDate())
                .status(sensorRequest.status())
                .build();
    }


    private SensorResponse entityToDtoMapper(Sensor sensor) {
        return SensorResponse.builder()
                .id(sensor.getId())
                .installationDate(sensor.getInstallationDate())
                .sensorNumber(sensor.getSensorNumber())
                .model(sensor.getModel())
                .status(sensor.getStatus())
                .build();
    }


    public SensorResponse search(String uuid, String model) {
        if (uuid != null && !uuid.trim().isEmpty()) {
            return entityToDtoMapper(sensorService.searchByUUID(uuid));
        }else if (model != null && !model.trim().isEmpty()) {
            return entityToDtoMapper(sensorService.searchByModel(model));
        }
        throw new NotFoundException("Sensor has not been found");
    }
}
