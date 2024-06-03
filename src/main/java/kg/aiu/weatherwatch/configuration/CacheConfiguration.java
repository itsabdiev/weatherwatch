package kg.aiu.weatherwatch.configuration;

import kg.aiu.weatherwatch.cache.CacheStore;
import kg.aiu.weatherwatch.entity.Sensor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    @Bean
    public CacheStore<Sensor> sensorCache() {
        return new CacheStore<>(1, TimeUnit.MINUTES,100L);
    }

}
