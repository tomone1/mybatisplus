package com.wdgj.customer;

import com.alibaba.fastjson.JSON;
import com.diamond.services.WdgjApiSysParamsServices;
import com.util.Common;
import com.util.HttpUtil;

import com.wdgj.base.MyCache;
import com.wdgj.cach.SysParamCache;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author tom
 * @Date 2018-04-10 15:18
 */
@Service
@Slf4j(topic = "customerLog")
public class Wdgjcustomermemberlist {
  @Value("${apiurl}")
  private String apiurl;
  @Value("${appkey}")
  private String appkey;
  private final String method="wdgj.customer.member.list";
  @Autowired
  private SysParamCache sysParamCache;
 public String httpPostString(String page_no,String modify_date)throws Exception{
   Map dic = sysParamCache.getSysparams(appkey);
   log.info("方法 wdgj.customer.member.list 参数为 {}"+ JSON.toJSON(dic));
  //添加系统级参数
  dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));
   //添加应用级参数 wdgj.customer.member.list

  //非必须参数如果不传值需要删除该行
  dic.put("method",method);
  dic.put("modify_date", modify_date);//参数modify_date的值，类型datetime，必须

  dic.put("page_no", page_no);//参数page_no的值，类型int，必须

  dic.put("page_size", "100");//参数page_size的值，类型int，必须

  dic.put("Customer_ID", "");//参数Customer_ID的值，类型int，非必须

  dic.put("ShopID", "");//参数ShopID的值，类型int，非必须

  dic.put("SearchKey", "");//参数SearchKey的值，类型string，非必须
   String appsecret="";
   if(dic.get("appsecret")==null){
     dic=MyCache.getPathMap();
     appsecret=MyCache.getAppsecret();
     log.info("appsecret 为空");
   }else{
     appsecret=dic.get("appsecret").toString();
   }

  //计算sign
  dic.remove("sign");
  dic.remove("appsecret");
  String sign = Common.getSign(appsecret, dic);
  dic.put("sign", sign);

  //将字典类型的参数转成x-www-form-urlencoded的形式
  String poststr = Common.ChangeToPostValue(dic);
  poststr="a=json&"+poststr;
  log.info("请求参数集{}",poststr);
  //发送post请求
  return HttpUtil.doPostRequest(apiurl, poststr);
}

}
