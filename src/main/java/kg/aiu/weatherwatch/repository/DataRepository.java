package kg.aiu.weatherwatch.repository;

import kg.aiu.weatherwatch.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface DataRepository extends JpaRepository<Data,Long> {

    @Override
    @Query(value = "SELECT * FROM datas WHERE deleted IS NULL",
            nativeQuery = true )
    List<Data> findAll();

    @Override
    @Query(value = "SELECT d.*  FROM datas d WHERE d.id = ? AND d.deleted IS NULL",
            nativeQuery = true )
    Data getById(Long id);


    @Query(value = "SELECT d.*  FROM datas d WHERE d.sensor_id = ? AND d.deleted IS NULL",
            nativeQuery = true )
    Optional<Data> existsBySensorId(Long id);

    @Query(value = "SELECT COUNT(d) > 0 FROM datas d WHERE d.id = ? AND d.deleted IS NULL",
            nativeQuery = true )
    boolean existsById(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE datas SET deleted = NOW() WHERE id = ?",
            nativeQuery = true)
    void removeById(Long id);
}
