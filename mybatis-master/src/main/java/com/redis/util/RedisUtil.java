package com.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author tom
 * @Date 2018/3/28 11:50
 */

public class RedisUtil {
  @Autowired
  private RedisTemplate<Serializable,Object> redisTemplate;
  /*
  * 批量刪除对应的value
  * */
  public void remove(final String ... keys){
      for (String key:keys){
        remove(key);
      }
  }
  /*
  *  批量删除key
  * */
  public  void removePattern(final String pattern){
    Set<Serializable> keys=redisTemplate.keys(pattern);
    if(keys.size()>0){
      redisTemplate.delete(keys);
    }
  }

  /*
  * 删除对应的value
  * */
  public  void remove(final String key){
    if(exits(key)){
      redisTemplate.delete(key);
    }

  }
  /*
  *确定是否存在该key
  * */
  public boolean exits(final String key){
    return redisTemplate.hasKey(key);
  }
  /*
  * 读取缓存
  * */
  public Object get(final  String key){
    Object result=null;
    ValueOperations<Serializable,Object> operations=redisTemplate.opsForValue();
    result=operations.get(key);
    return result;
  }
  /*
  *
  * */
  public Object get(final String key,final String hashkey){
    Object result=null;
    HashOperations<Serializable,Object,Object> operations=redisTemplate.opsForHash();
    result=operations.get(key,hashkey);
    return result;
  }
  /*
  *  写入缓存
  * */
  public boolean set(final  String key,Object value){
    boolean result=false;
    try{
      ValueOperations<Serializable,Object>operations=redisTemplate.opsForValue();
      operations.set(key,value);
      result=true;
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  /*
  *
  * */
  public boolean set(final String key,final String hashkey,Object value){
    boolean result=false;
    try{
      HashOperations<Serializable,Object,Object> operations=redisTemplate.opsForHash();
      operations.put(key,hashkey,value);
      result=true;
    }catch(Exception e){
      e.printStackTrace();
    }
    return  result;
  }
  /*
  *
  * 写入缓存
  * */
  public boolean set(final String key,Object value,long expireTime){
    boolean result=false;
    try{
      ValueOperations<Serializable,Object> operations=redisTemplate.opsForValue();
      operations.set(key,value);
      redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
      result=true;
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  /*
  *
  * */
}
