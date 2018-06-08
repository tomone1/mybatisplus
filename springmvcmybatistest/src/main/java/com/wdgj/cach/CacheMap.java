package com.wdgj.cach;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author tom
 * @Date 2018-05-03 16:33
 */
// @Service
public class CacheMap {
  public static int DEFAULT_CACHE_MINUTE = 5;
  /**
   * 数据缓存map
   */
  private static Map<String, Object> dataMap = new ConcurrentHashMap<>();
  /**
   * 数据缓存过期map
   */
  private static Map<String, Date> dataExpireMap = new ConcurrentHashMap<String, Date>();

  /**
   * 将一个key、value值放入内存缓存,并设置过期分钟数
   *
   * @param key
   * @param val
   * @param expireMiute
   */
  public static void put(String key, Object val, int expireMiute) {
    dataMap.put(key, val);
    dataExpireMap.put(key, DateUtils.addMinutes(new Date(), expireMiute));
  }

  /**
   * 从缓存中获取一个key的数据(若过期返回null)
   *
   * @param key
   * @return
   */
  public static Object get(String cacheKey) {
    Object obj = null;
    Date expireDate = CacheMap.dataExpireMap.get(cacheKey);
    if (expireDate != null && expireDate.compareTo(new Date()) > 0) {
      obj = CacheMap.dataMap.get(cacheKey);
    }
    return obj;
  }

}
