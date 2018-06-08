package com.wdgj.trade;

import com.alibaba.fastjson.JSON;
import com.diamond.model.pojo.JsonTradeRootBean;

/**
 * @Author tom
 * @Date 2018-04-18 15:17
 */

public class testJson {
  public static void main(String[] args) {
    String str="{ \"returncode\": \"0\", \"returninfo\": \"0\" }";
    JsonTradeRootBean jsonTradeRootBean= JSON.parseObject(str,    JsonTradeRootBean.class);
    System.out.println(jsonTradeRootBean.getDatalist().size());
  }
}
