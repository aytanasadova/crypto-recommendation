package xm.cryptorecommendation.config;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
@Component
public class CacheService {
    private final CacheManager cacheManager;

    /**
     * @param cacheManager
     */
    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * To evict all caches
     */
    public void evictAllCacheValues() {
        for (String cacheName : cacheManager.getCacheNames()) {
            Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        }
        System.out.println("Cache cleared");
    }
}
