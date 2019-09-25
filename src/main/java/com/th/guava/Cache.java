package com.th.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class Cache {
    private LoadingCache<String, String> nameCache =
            CacheBuilder.newBuilder().expireAfterWrite(150, TimeUnit.SECONDS).maximumSize(5)
                    .build(new CacheLoader<String, String>() {
                        @Override
                        public String load(String key) throws Exception {
                            return getName(key);
                        }
                    });

    public String getFromCache(String key) {
        return nameCache.getUnchecked(key);
    }

    private String getName(String key) {
        return "name:" + key;
    }
}
