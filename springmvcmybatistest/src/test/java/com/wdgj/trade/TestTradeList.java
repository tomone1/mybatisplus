package com.wdgj.trade;

import com.wdgj.api.WdgjTradeListApi;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author tom
 * @Date 2018-04-17 11:48
 */
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TestTradeList {
@Autowired
private WdgjTradeList wdgjTradeList;
@Autowired
private WdgjTradeListApi wdgjTradeListApi;
@Test
  public void test()throws Exception{
//   String str= wdgjTradeList.httpPostString(Integer.toString(1548),"0","2001-01-01","2019-01-01");
//  System.out.println(str.toString());
  }
@Test
  public void testwd()throws Exception{
  wdgjTradeListApi.saveWdjTradeInfo();;
}

}
