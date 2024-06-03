package kg.aiu.weatherwatch.repository;

import kg.aiu.weatherwatch.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert,Long> {

    @Override
    @Query(value = "SELECT * FROM alerts WHERE deleted IS NULL",
            nativeQuery = true )
    List<Alert> findAll();

    @Override
    @Query(value = "SELECT a.*  FROM alerts a WHERE a.id = ? AND a.deleted IS NULL",
            nativeQuery = true )
    Alert getById(Long id);

    @Query(value = "SELECT COUNT(a) > 0 FROM alerts a WHERE a.id = ? AND a.deleted IS NULL",
            nativeQuery = true )
    boolean existsById(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE alerts SET deleted = NOW() WHERE id = ?",
            nativeQuery = true)
    void removeById(Long id);
}
