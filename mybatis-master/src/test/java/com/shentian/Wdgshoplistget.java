package com.shentian;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-04-08 17:36
 */

public class Wdgshoplistget {

/*  accesstoken d10c3d88bd984707bfae92c68a4fcd2e
  appkey :16843421
  appsecret:407150khiekco58og526nmoda8d8cglm*/


    private Map<String, String> dic;

    private String appkey = "16843421";

    private String appsecret = "407150khiekco58og526nmoda8d8cglm";

    private String accesstoken = "d10c3d88bd984707bfae92c68a4fcd2e";
  // private String accesstoken = "9a68d15e10c444b392f8977fd3508ab5";

    private String apiurl = "http://api.wdgj.com/wdgjcloud/api";

    public String httpPostString()

   throws Exception {

      dic = new HashMap<>();

      //添加系统级参数

      dic.put("appkey", appkey);

      dic.put("accesstoken", accesstoken);

      dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));

      dic.put("method", "wdgj.com.shoplist.query");

      dic.put("versions", "1.1");//支持1.0和1.1

      dic.put("format", "json");//支持json和xml，如需返回json格式，替换xml为json
      dic.put("method", "wdgj.com.shoplist.query");
      //添加应用级参数

      //非必须参数如果不传值需要删除该行

//      dic.put("searchtype", "0");//参数searchtype的值，类型string，必须
//
//      dic.put("begintime", "2000-01-01");//参数begintime的值，类型String，必须
//
//      dic.put("endtime", "2019-01-01");//参数endtime的值，类型String，必须
//
//      dic.put("pageno", "3");//参数pageno的值，类型String，必须
//
//      dic.put("pagesize", "1");//参数pagesize的值，类型String，必须
//
//      dic.put("timetype", "0");//参数timetype的值，类型string，非必须
//
//      dic.put("searchstatus", "");//参数searchstatus的值，类型string，非必须
//
//      dic.put("searchno", "");//参数searchno的值，类型string，非必须
//
//      dic.put("relationno", "");//参数relationno的值，类型string，非必须

      dic.put("ShopType", "");//参数warehouseno的值，类型string，非必须
      dic.put("method", "wdgj.com.shoplist.query");
      //计算sign

      String sign = Common.getSign(appsecret, dic);

      dic.put("sign", sign);

      //将字典类型的参数转成x-www-form-urlencoded的形式

      String poststr = Common.ChangeToPostValue(dic);
      poststr="method=wdgj.com.shoplist.query&"+poststr;
      System.out.println(poststr);

      //发送post请求

      return HttpUtil.doPostRequest(apiurl, poststr);

    }

  public static void main(String[] args) throws Exception {
    String a=  new Wdgshoplistget().httpPostString();
    Map map=new HashMap();
   map= JSON.parseObject(a,Map.class);

   /* List list=(List) map.get("datalist");

    System.out.println(list.size());*/
    System.out.println(a);
  }


}
