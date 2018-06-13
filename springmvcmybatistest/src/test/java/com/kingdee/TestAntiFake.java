package com.kingdee;

import com.kingdee.api.AntiFakeInfoImport;
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
public class TestAntiFake {
  @Autowired
  private AntiFakeInfoImport antiFakeInfoImport;
  @Test
  public void test(){
    antiFakeInfoImport.loadFile();
  }
}
