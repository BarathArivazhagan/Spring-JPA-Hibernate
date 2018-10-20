package com.barath.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(value = "/caches")
public class CacheController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final CacheManager cacheManager;


    public CacheController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @GetMapping(value = "/{cacheName}/{key}")
    public Object cacheData(@PathVariable String cacheName, @PathVariable String key) {

       if (logger.isInfoEnabled()) {  logger.info("get cache {} with key {}",cacheName,key);}
       Cache cache = this.cacheManager.getCache(cacheName);
       Object value = cache.get(key);
       if (logger.isInfoEnabled()) {  logger.info(" cache {} with key {} and value {}",cacheName,key,value);}
       return value;
    }

    @DeleteMapping(value = "/{cacheName}/{key}")
    public void deleteCacheWithKey(@PathVariable String cacheName, @PathVariable String key) {

        if (logger.isInfoEnabled()) {  logger.info("delete cache {} with key {}",cacheName,key);}
        Cache cache = this.cacheManager.getCache(cacheName);
        cache.evict(key);
    }



}
