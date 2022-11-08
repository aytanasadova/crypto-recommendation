package xm.cryptorecommendation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CacheService {
    @Autowired
    CacheManager cacheManager;

    public void evictAllCacheValues() {
        for (String cacheName : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        }
        System.out.println("Cache cleared");
    }
}
