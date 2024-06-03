package kg.aiu.weatherwatch.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Entity
@SuperBuilder
@Table(name = "datas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Data extends BaseEntity {

    Integer humidity;
    Integer temperature;
    Integer windSpeed;
    Timestamp registrationTime;

    @OneToOne
    @JoinColumn(name = "sensor_id")
    Sensor sensor;
}
