package com.wdgj;

import com.alibaba.fastjson.JSON;
import com.diamond.model.pojo.JsonCustomerRootBean;
import com.diamond.services.WdgjCustomerInfoServices;
import com.wdgj.api.WdgjcustomermemberApi;
import com.wdgj.customer.Wdgjcustomermemberlist;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author tom
 * @Date 2018-04-10 15:33
 */
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TestCustomer {
@Autowired
  private WdgjcustomermemberApi WdgjcustomermemberApi;



@Test
public void testSaveCustomerInfo()throws Exception{
  WdgjcustomermemberApi.saveWdgjCustomerInfo();
  }


}
