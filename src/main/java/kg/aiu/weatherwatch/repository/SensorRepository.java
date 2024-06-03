package kg.aiu.weatherwatch.repository;

import kg.aiu.weatherwatch.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor,Long> {

    @Query(value = "SELECT COUNT(s) > 0 FROM sensors s WHERE s.model = ? AND s.deleted IS NULL",
            nativeQuery = true )
    boolean existsByModel(String model);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sensors SET deleted = NOW() WHERE id = ?",
            nativeQuery = true)
    void removeById(Long id);


    @Query(value = "SELECT COUNT(s) > 0 FROM sensors s WHERE s.id = ? AND s.deleted IS NULL",
            nativeQuery = true )
    boolean existsById(Long id);

    @Override
    @Query(value = "SELECT s.*  FROM sensors s WHERE s.id = ? AND s.deleted IS NULL",
            nativeQuery = true )
    Sensor getById(Long id);

    @Override
    @Query(value = "SELECT * FROM sensors WHERE deleted IS NULL",
            nativeQuery = true )
    List<Sensor> findAll();


    @Query(value = "SELECT * FROM sensors WHERE sensor_number = ? AND deleted IS NULL",nativeQuery = true)
    Sensor findByUUID(String uuid);

    @Query(value = "SELECT * FROM sensors WHERE model = ? AND deleted IS NULL",nativeQuery = true)
    Sensor findByModel(String model);
}
