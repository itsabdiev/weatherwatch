package kg.aiu.weatherwatch.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kg.aiu.weatherwatch.entity.enums.SensorStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;

@Entity
@SuperBuilder
@Table(name = "sensors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "sensorNumber", callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sensor extends BaseEntity {

    UUID sensorNumber;

    String model;

    Date installationDate;

    SensorStatus status;
}
