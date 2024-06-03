package kg.aiu.weatherwatch.service;

import kg.aiu.weatherwatch.entity.Data;

import java.util.List;
import java.util.Optional;

public interface DataService {
    List<Data> getAll();

    Data getById(Long id);

    Optional<Data> existsBySensorId(Long id);

    void save(Data data);

    boolean existsById(Long id);

    void deleteById(Long id);
}
