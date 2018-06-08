package com.wdgj.customer;

import com.alibaba.fastjson.JSON;
import com.diamond.services.WdgjApiSysParamsServices;
import com.util.Common;
import com.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-04-10 15:18
 */
@Service
@Slf4j
public class Wdgjcustomermemberlist2 {
  @Value("${apiurl}")
  private String apiurl;


  private static final String method = "wdgj.customer.member.list";
  private static final String accesstoken = "44f7d7feed1446ef86fcfdc300ed1ddc";
  private static final String appsecret = "4bf1h386ibhkki90hag4b7gdldfdo6m5";
  private static final String appkey = "26353827";
  private static final String sign = "";
  private static final String timestamp = "";
  private static final String format = "json";
  private static final String versions = "1.0";
  private static final long serialVersionUID = 8215851505074905693L;
  private static Map<String, String> pathMap = new HashMap<String, String>(){


    /**
     * 给Map初始化、赋值
     */
    private static final long serialVersionUID = 8215851505074905693L;
    {
      put("method",method);
      put("accesstoken",accesstoken);
      //put("appsecret",appsecret);
      put("appkey",appkey);
     // put("sign",sign);
   //   put("timestamp",timestamp);
      put("format",format);
      put("versions",versions);


    }
  };
  @Autowired
  private WdgjApiSysParamsServices wdgjApiSysParamsServices;
 public String httpPostString(String page_no)throws Exception{
   Map dic = pathMap;
   System.out.println("方法 wdgj.customer.member.list 参数为 {}"+ JSON.toJSON(dic));
  //添加系统级参数
  dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));
   //添加应用级参数 wdgj.customer.member.list

  //非必须参数如果不传值需要删除该行

  dic.put("modify_date", "2000-01-01");//参数modify_date的值，类型datetime，必须

  dic.put("page_no", page_no);//参数page_no的值，类型int，必须

  dic.put("page_size", "100");//参数page_size的值，类型int，必须

  dic.put("Customer_ID", "");//参数Customer_ID的值，类型int，非必须

  dic.put("ShopID", "");//参数ShopID的值，类型int，非必须

  dic.put("SearchKey", "");//参数SearchKey的值，类型string，非必须
   /*String appsecret="";
   if(dic.get("appsecret")==null){
     dic=MyCache.getPathMap();
     appsecret=MyCache.getAppsecret();
     log.info("appsecret 为空");
   }else{
     appsecret=dic.get("appsecret").toString();
   }*/

  //计算sign
  //dic.remove("sign");
  //dic.remove("appsecret");
  String sign = Common.getSign(appsecret, dic);
   ;
  dic.put("sign", sign);

  //将字典类型的参数转成x-www-form-urlencoded的形式

  String poststr = Common.ChangeToPostValue(dic);
  poststr="a=json&"+poststr;
  System.out.println(poststr);
  //发送post请求
  return HttpUtil.doPostRequest(apiurl, poststr);
}

}
