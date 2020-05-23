package com.springboot.productdemo.web.configs;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport{
	
	@Bean
	public net.sf.ehcache.CacheManager ehCacheManager() {
		CacheConfiguration productCache = new CacheConfiguration();
		productCache.setName("product-cache");
		productCache.setMemoryStoreEvictionPolicy("LRU");
		productCache.setEternal(false);
		productCache.setTimeToIdleSeconds(0);
		productCache.setMaxEntriesLocalHeap(1000);
		productCache.setTimeToLiveSeconds(10);

		//We can set multiple cache

		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
		config.addCache(productCache);
		
		return net.sf.ehcache.CacheManager.newInstance(config);
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}
	

}
