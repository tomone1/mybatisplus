package com.shentian;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018/3/22 14:53
 */

public class Test
{
  private Map<String, String> dic;
  private String appkey = "40420831";
  private String appsecret = "malc12m3agg1285kk2ae20eag19797b9";
  private String accesstoken = "384daa4f924040fb869942354e2b2b9c";
  private String apiurl = "http://api.wdgj.com/wdgjcloud/api";

  public String httpPostString () throws Exception
  {
    dic = new HashMap<>();
    //添加系统级参数
    dic.put("appkey", appkey);
    dic.put("accesstoken", accesstoken);
    dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));
    dic.put("method", "wdgj.customer.list.get");
    //dic.put("method", "wdgj.trade.list.get");
    //dic.put("method", "wdgj.customer.member.list");
    dic.put("versions", "1.0");//支持1.0和1.1
    dic.put("format", "json");//支持json和xml，如需返回json格式，替换xml为json
    //添加应用级参数
    //非必须参数如果不传值需要删除该行
    dic.put("modifydate", "2017-01-01");//参数modifydate的值，类型	string		，非必须
    dic.put("modifydate", "2017-01-01");//参数modifydate的值，类型	string		，非必须
    dic.put("pageno", "1");//参数pageno的值，类型string，必须
    dic.put("pagesize", "1");//参数pagesize的值，类型string ，必须
    dic.put("searchno", "");//参数searchno的值，类型string，非必须
    dic.put("searchname", "");//参数searchname的值，类型string，非必须
    dic.put("begintime", "");//参数begintime的值，类型string，非必须
    dic.put("endtime", "");//参数endtime的值，类型string，非必须
    //计算sign
    String sign = Common.getSign(appsecret,dic);
    dic.put("sign", sign);
    //将字典类型的参数转成x-www-form-urlencoded的形式
    String poststr = Common.ChangeToPostValue(dic);
    //发送post请求
    System.out.println(sign);
    return  HttpUtil.doPostRequest(apiurl, poststr);

  }

  public static void main(String[] args)throws Exception {
  String a=  new Test().httpPostString();
    System.out.println(a);
  }
}
