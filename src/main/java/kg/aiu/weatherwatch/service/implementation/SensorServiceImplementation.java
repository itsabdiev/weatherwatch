package kg.aiu.weatherwatch.service.implementation;

import kg.aiu.weatherwatch.cache.CacheStore;
import kg.aiu.weatherwatch.entity.Sensor;
import kg.aiu.weatherwatch.repository.SensorRepository;
import kg.aiu.weatherwatch.service.SensorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


;import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SensorServiceImplementation implements SensorService {

    SensorRepository sensorRepository;
    CacheStore<Sensor> cacheStore;

    @Override
    public boolean existsByModel(String model) {
        return sensorRepository.existsByModel(model);
    }

    @Override
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public boolean existsById(Long id) {
        return sensorRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        sensorRepository.removeById(id);
    }

    @Override
    public Sensor getById(Long id) {
        return sensorRepository.getById(id);
    }

    @Override
    public List<Sensor> getAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor searchByUUID(String uuid) {
        String generatedKey = generateKey(uuid, false);
        Sensor sensor = cacheStore.get(generatedKey);
        if (sensor != null) {
            return sensor;
        }
        Sensor byUUID = sensorRepository.findByUUID(uuid);
        cacheStore.add(generatedKey,byUUID);
        return byUUID;
    }

    @Override
    public Sensor searchByModel(String model) {
        String generatedKey = generateKey(model, true);
        Sensor sensor = cacheStore.get(generatedKey);
        if (sensor != null) {
            return sensor;
        }
        Sensor byModel = sensorRepository.findByModel(model);
        cacheStore.add(generatedKey,byModel);
        return byModel;
    }

    private String generateKey(String key,boolean isModel) {
        if (isModel) return "MODEL" + key;
        return "UUID" + key;
    }
}
