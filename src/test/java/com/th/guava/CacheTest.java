package com.th.guava;

import org.junit.Test;

import static org.junit.Assert.*;

public class CacheTest {

    private Cache cache = new Cache();

    @Test
    public void getFromCache() throws InterruptedException {
        cache.getFromCache("aa");
        cache.getFromCache("bb");
        cache.getFromCache("cc");
        cache.getFromCache("dd");
        cache.getFromCache("ee");
        cache.getFromCache("ff");
        cache.getFromCache("aa");
        Thread.sleep(5000);
        cache.getFromCache("aa");
    }
}
