package xm.cryptorecommendation.config;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CacheService {
    private final CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void evictAllCacheValues() {
        for (String cacheName : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        }
        System.out.println("Cache cleared");
    }
}
