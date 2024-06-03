package kg.aiu.weatherwatch.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CacheStore<T> {
    private final Cache<String, T> cache;

    public CacheStore(int expiryDuration, TimeUnit timeUnit,Long maximumSize) {
        cache = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterWrite(expiryDuration, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
    }

    public T get(String key) {
        return cache.getIfPresent(key);
    }

    public void add(String key, T value) {
        if(key != null && value != null) {
            log.info("CacheStore : Data with key {}  and value {} has been saved",key,value);
            cache.put(key, value);
        }
    }
}