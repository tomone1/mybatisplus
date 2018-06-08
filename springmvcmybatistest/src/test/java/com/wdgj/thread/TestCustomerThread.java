package com.wdgj.thread;

import com.wdgj.thread.WdgjcustomermemberThread;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author tom
 * @Date 2018-04-13 14:46
 */
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TestCustomerThread {
  @Autowired
  private WdgjcustomermemberThread wdgjcustomermemberThread;
  @Test
  public void test(){
    wdgjcustomermemberThread.saveMultiCustomerInfo();
  }

}
