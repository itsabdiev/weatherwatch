package kg.aiu.weatherwatch.service;

import kg.aiu.weatherwatch.entity.Sensor;

import java.util.List;

public interface SensorService {

    boolean existsByModel(String model);

    void save(Sensor sensor);

    boolean existsById(Long id);

    void deleteById(Long id);

    Sensor getById(Long id);

    List<Sensor> getAll();

    Sensor searchByUUID(String uuid);

    Sensor searchByModel(String model);
}
