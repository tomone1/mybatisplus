package com.kingdee;

import com.kingdee.api.ProductImport;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author tom
 * @Date 2018-06-12 15:38
 */
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TestProduct {
  @Autowired
  private ProductImport productImport;
  @Test
  public void test(){
    productImport.loadFile();
  }
}
