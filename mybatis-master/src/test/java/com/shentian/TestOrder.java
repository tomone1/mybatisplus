package com.shentian;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018/3/26 10:39
 */

public class TestOrder {

  private Map<String, String> dic;
  private String appkey = "40420831";
  private String appsecret = "malc12m3agg1285kk2ae20eag19797b9";
  private String accesstoken = "384daa4f924040fb869942354e2b2b9c";
  private String apiurl = "http://api.wdgj.com/wdgjcloud/api";
  public String httpPostString () throws Exception
  {
    dic = new HashMap<>();
    //添加系统级参数

    /*
    *
    * timestamp=1522032753&method=wdgj.com.trade.list&appkey=45030753&accesstoken=65be7747b49a4060a28030dfd1c0e56f&format=json&versions=1.0&trade_arc=0&page_no=1&page_size=1&begin_time=2016-01-01&end_time=2016-02-02&time_type=0&sign=2e854f790da7c7cfa5204de836c2dec9*/
    dic.put("appkey", appkey);
    dic.put("accesstoken", accesstoken);
    dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));
    //dic.put("method", "wdgj.customer.list.get");
    //dic.put("method", "wdgj.trade.list.get");
    dic.put("method", "wdgj.com.warehouse.create");
    dic.put("versions", "1.0");//支持1.0和1.1
    dic.put("format", "json");//支持json和xml，如需返回json格式，替换xml为json
    //添加应用级参数
    //非必须参数如果不传值需要删除该行
    dic.put("trade_arc","0");
    dic.put("time_type","0");

    dic.put("begin_time", "2017-01-01");//参数modifydate的值，类型	string		，非必须
    dic.put("end_time", "2017-02-01");//参数modifydate的值，类型	string		，非必须
    dic.put("page_no", "1");//参数pageno的值，类型string，必须
    dic.put("page_size", "1");//参数pagesize的值，类型string ，必须

    //计算sign
    String sign = Common.getSign(appsecret,dic);
    dic.put("sign", sign);
    System.out.println(dic.get("sign").length());
    System.out.println(dic.get("timestamp"));
    System.out.println(dic.get("timestamp").length());


    //将字典类型的参数转成x-www-form-urlencoded的形式
    String poststr = Common.ChangeToPostValue(dic);
    System.out.println(poststr);
    //发送post请求
    return  HttpUtil.doPostRequest(apiurl, poststr);

  }

  public static void main(String[] args)throws Exception {
    String a=  new TestOrder().httpPostString();
    System.out.println(a);
  }

}
