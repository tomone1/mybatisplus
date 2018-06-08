package com.diamond;

import com.alibaba.fastjson.JSON;
import com.diamond.services.WdgjApiSysParamsServices;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @Author tom
 * @Date 2018-04-09 16:02
 */
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {
 @Autowired
  private WdgjApiSysParamsServices wdgjApiSysParamsServices;
 @org.junit.Test
  public  void testcust(){
   Map map=wdgjApiSysParamsServices.findWdgjApiSysParams("wdgj.customer.member.list");
  System.out.println(JSON.toJSON(map));
 }

}
