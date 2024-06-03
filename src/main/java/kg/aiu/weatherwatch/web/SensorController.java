package kg.aiu.weatherwatch.web;


import kg.aiu.weatherwatch.dto.request.SensorRequest;
import kg.aiu.weatherwatch.dto.response.MessageResponse;
import kg.aiu.weatherwatch.dto.response.SensorResponse;
import kg.aiu.weatherwatch.endpoint.SensorEndpoint;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SensorController {

    SensorEndpoint sensorEndpoint;

    @GetMapping
    public List<SensorResponse> getAll() {
        return sensorEndpoint.getAll();
    }


    @GetMapping("/search")
    public SensorResponse search(@RequestParam(required = false) String uuid,
                                       @RequestParam(required = false) String model) {
        return sensorEndpoint.search(uuid,model);
    }

    @GetMapping("/{id}")
    public SensorResponse getById(@PathVariable Long id) {
        return sensorEndpoint.getById(id);
    }

    @PostMapping
    public MessageResponse save(@RequestBody SensorRequest sensorRequest) {
        return sensorEndpoint.save(sensorRequest);
    }

    @PutMapping("/{id}")
    public MessageResponse update(@RequestBody SensorRequest sensorRequest, @PathVariable Long id) {
        return sensorEndpoint.update(id,sensorRequest);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return sensorEndpoint.delete(id);
    }

}
