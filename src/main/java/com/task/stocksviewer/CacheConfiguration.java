package com.task.stocksviewer;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfiguration {
	private static final long CACHE_EXPIRE_AFTER_ACCESS_IN_MINUTES = 10;
	private static final String CACHE_NAME = "stocks";

	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager(CACHE_NAME);
		caffeineCacheManager.setCaffeine(caffeineCacheBuilder());
		return caffeineCacheManager;
	}

	private Caffeine<Object, Object> caffeineCacheBuilder() {
		return Caffeine.newBuilder()
				.expireAfterAccess(CACHE_EXPIRE_AFTER_ACCESS_IN_MINUTES, TimeUnit.MINUTES);
	}

}
