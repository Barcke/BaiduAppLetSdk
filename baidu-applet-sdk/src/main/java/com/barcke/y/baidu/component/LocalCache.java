package com.barcke.y.baidu.component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
  *                  ,;,,;
  *                ,;;'(    社
  *      __      ,;;' ' \   会
  *   /'  '\'~~'~' \ /'\.)  主
  * ,;(      )    /  |.     义
  *,;' \    /-.,,(   ) \    码
  *     ) /       ) / )|    农
  *     ||        ||  \)     
  *     (_\       (_\
  *
  * @ProjectName BaiduAppLetSdk
  * @ClassName LocalCahe
  * @Description TODO
  * @Author Barcke
  * @Date 2020/5/26 1:53 下午
  * @Version 1.0
  * @slogan: 源于生活 高于生活
  * @description: 缓存类 用于缓存token等信息
  **/
@Slf4j
public class LocalCache<T> {

    private Cache<String,T> localCache = null;

    @PostConstruct
    private void init(){
        localCache = CacheBuilder.newBuilder()
                //设置本地缓存容器的初始容量
                .initialCapacity(10)
                //设置本地缓存的最大容量
                .maximumSize(500)
                //设置写缓存后多少秒过期
                .expireAfterWrite(60, TimeUnit.SECONDS).build();
    }

    public void setLocalCache(String key,T object){
        localCache.put(key,object);
    }

    public <T> T getCache(String key){
        return (T) localCache.getIfPresent(key);
    }

    public void remove(String key){
        localCache.invalidate(key);
    }
}
