package kg.aiu.weatherwatch.configuration;

import kg.aiu.weatherwatch.cache.CacheStore;
import kg.aiu.weatherwatch.entity.Sensor;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheConfiguration {

    @Bean
    public CacheStore<List<Sensor>> sensorsCache() {
        return new CacheStore<>(1, TimeUnit.MINUTES,10L);
    }

}
