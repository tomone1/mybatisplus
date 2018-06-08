package com.redis.services;

import com.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tom
 * @Date 2018/3/28 14:28
 */
@Service("redisTestService")
public class RedisTestServiceImpl {
  @Autowired
  private RedisUtil redisUtil;


}
