package com.redis;

import com.redis.util.RedisUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author tom
 * @Date 2018/3/28 14:35
 */

public class TestRedisCach {
  @Autowired
  RedisUtil redisUtil;
  private ClassPathXmlApplicationContext context;
  @Before
  public  void initConfig(){
    context=new ClassPathXmlApplicationContext("spring.xml");
   // context.setValidating(false);
    redisUtil=(RedisUtil) context.getBean("redisUtil");

  }
  @After
  public void end(){
    if(context!=null){
      context.close();
    }
  }
  @Test
  public void testRedid(){
    redisUtil.set("name","9999999");
    System.out.println(redisUtil.get("name"));
  }

}
