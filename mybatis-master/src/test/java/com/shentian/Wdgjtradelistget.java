package com.shentian;

import com.alibaba.fastjson.JSON;
import org.apache.derby.iapi.types.J2SEDataValueFactory;

import java.util.*;

/**
 * @Author tom
 * @Date 2018-04-08 17:36
 */

public class Wdgjtradelistget {

/*  accesstoken d10c3d88bd984707bfae92c68a4fcd2e
  appkey :16843421
  appsecret:407150khiekco58og526nmoda8d8cglm*/


    private Map<String, String> dic;

    private String appkey = "16843421";

    private String appsecret = "407150khiekco58og526nmoda8d8cglm";

    private String accesstoken = "9a68d15e10c444b392f8977fd3508ab5";//“eclohasl1”账号
    //private String accesstoken = "58242c4c341444519e98dce94ed74d79";//“eclohasl2”账号
    //private String accesstoken = "d10c3d88bd984707bfae92c68a4fcd2e";//“sentian”账号
  // private String accesstoken = "9a68d15e10c444b392f8977fd3508ab5";//

    private String apiurl = "http://api.wdgj.com/wdgjcloud/api";


//    public String httpPostString()
//
//   throws Exception {
//
//      dic = new HashMap<>();
//
//      //添加系统级参数
//
//      dic.put("appkey", appkey);
//
//      dic.put("accesstoken", accesstoken);
//
//      dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));
//
//      dic.put("method", "wdgj.trade.list.get");
//      //dic.put("method", "wdgj.com.trade.list");
//
//      dic.put("versions", "1.1");//支持1.0和1.1
//
//      dic.put("format", "json");//支持json和xml，如需返回json格式，替换xml为json
//
//      //添加应用级参数
//
//      //非必须参数如果不传值需要删除该行
//
//      dic.put("trade_arc", "");//参数trade_arc的值，类型int，必须
//
//      dic.put("page_no", "");//参数page_no的值，类型int，必须
//
//      dic.put("page_size", "");//参数page_size的值，类型int，必须
//
//      dic.put("begin_time", "2000-01-01");//参数begin_time的值，类型datetime，必须
//
//      dic.put("end_time", "2019-01-01");//参数end_time的值，类型datetime，必须
//
//      dic.put("trade_status", "");//参数trade_status的值，类型int，非必须
//
//      dic.put("time_type", "0");//参数time_type的值，类型int，必须
//
//      dic.put("TradeNO", "");//参数TradeNO的值，类型string，非必须
//
//      dic.put("TradeNO2", "");//参数TradeNO2的值，类型string，非必须
//
//      dic.put("ShopName", "");//参数ShopName的值，类型string，非必须
//
////      dic.put("searchtype", "0");//参数searchtype的值，类型string，必须
////
////      dic.put("begintime", "2000-01-01");//参数begintime的值，类型String，必须
////
////      dic.put("endtime", "2019-01-01");//参数endtime的值，类型String，必须
////
////      dic.put("pageno", "1");//参数pageno的值，类型String，必须
////
////      dic.put("page_size", "100");//参数pagesize的值，类型String，必须
////
////      dic.put("timetype", "0");//参数timetype的值，类型string，非必须
////
////      dic.put("searchstatus", "");//参数searchstatus的值，类型string，非必须
////
////      dic.put("searchno", "");//参数searchno的值，类型string，非必须
////
////      dic.put("relationno", "");//参数relationno的值，类型string，非必须
////
////      dic.put("warehouseno", "");//参数warehouseno的值，类型string，非必须
//
//      //计算sign
//
//      String sign = Common.getSign(appsecret, dic);
//
//      dic.put("sign", sign);
//
//      //将字典类型的参数转成x-www-form-urlencoded的形式
//
//      String poststr = Common.ChangeToPostValue(dic);
//      poststr=""+poststr;
//      System.out.println(poststr);
//
//      //发送post请求
//
//      return HttpUtil.doPostRequest(apiurl, poststr);
//
//    }
  public String httpPostString(String shopname,String accesstoken)

      throws Exception {

    dic = new HashMap<>();


    //添加系统级参数

    dic.put("appkey", appkey);

    dic.put("accesstoken", accesstoken);

    dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));

    dic.put("method", "wdgj.trade.list.get");
    //dic.put("method", "wdgj.com.trade.list");

    dic.put("versions", "1.1");//支持1.0和1.1

    dic.put("format", "json");//支持json和xml，如需返回json格式，替换xml为json

    //添加应用级参数

    //非必须参数如果不传值需要删除该行

//    dic.put("trade_arc", "0");//参数trade_arc的值，类型int，必须
//
//    dic.put("page_no", "1");//参数page_no的值，类型int，必须
//
//    dic.put("page_size", "1");//参数page_size的值，类型int，必须
//
//    dic.put("begin_time", "2000-01-01");//参数begin_time的值，类型datetime，必须
//
//    dic.put("end_time", "2019-01-01");//参数end_time的值，类型datetime，必须
//
//    dic.put("trade_status", "");//参数trade_status的值，类型int，非必须
//
//    dic.put("time_type", "0");//参数time_type的值，类型int，必须
//
//    dic.put("TradeNO", "");//参数TradeNO的值，类型string，非必须
//
//    dic.put("TradeNO2", "");//参数TradeNO2的值，类型string，非必须

//    dic.Add("searchtype", "");//参数searchtype的值，类型string，必须
//    dic.Add("begintime", "");//参数begintime的值，类型String，必须
//    dic.Add("endtime", "");//参数endtime的值，类型String，必须
//    dic.Add("pageno", "");//参数pageno的值，类型String，必须
//    dic.Add("pagesize", "");//参数pagesize的值，类型String，必须
//    dic.Add("timetype", "");//参数timetype的值，类型string，非必须
//    dic.Add("searchstatus", "");//参数searchstatus的值，类型string，非必须
//    dic.Add("searchno", "");//参数searchno的值，类型string，非必须
//    dic.Add("relationno", "");//参数relationno的值，类型string，非必须
//    dic.Add("warehouseno", "");//参数warehouseno的值，类型string，非必须
//    dic.Add("operationtype", "");//参数operationtype的值，类型string，非必须
//    dic.Add("querymarkup", "");//参数querymarkup的值，类型string，非必须

    dic.put("ShopName", shopname);//参数ShopName的值，类型string，非必须


    dic.put("searchtype", "1");//参数searchtype的值，类型string，必须

    dic.put("begintime", "2000-01-01");//参数begintime的值，类型String，必须

    dic.put("endtime", "2019-01-01");//参数endtime的值，类型String，必须

    dic.put("pageno", "5396");//参数pageno的值，类型String，必须

    dic.put("pagesize", "100");//参数pagesize的值，类型String，必须

    dic.put("timetype", "0");//参数timetype的值，类型string，非必须

    dic.put("searchstatus", "");//参数searchstatus的值，类型string，非必须

    dic.put("searchno", "");//参数searchno的值，类型string，非必须

    dic.put("relationno", "");//参数relationno的值，类型string，非必须

    dic.put("warehouseno", "");//参数warehouseno的值，类型string，非必须
    dic.put("ShopName", shopname);//参数warehouseno的值，类型string，非必须

    //计算sign

    String sign = Common.getSign(appsecret, dic);

    dic.put("sign", sign);

    //将字典类型的参数转成x-www-form-urlencoded的形式

    String poststr = Common.ChangeToPostValue(dic);
    poststr=""+poststr;
    System.out.println(poststr);

    //发送post请求

    return HttpUtil.doPostRequest(apiurl, poststr);

  }
  public static void main(String[] args) throws Exception {

    String[] tokens={"58242c4c341444519e98dce94ed74d79"};//,"58242c4c341444519e98dce94ed74d79","d10c3d88bd984707bfae92c68a4fcd2e"
   List list=new ArrayList(Arrays.asList("森田药妆海外旗舰店"));
    for (int i = 0; i <list.size() ; i++) {
      System.out.println(list.get(i));
      Map map=new HashMap();

      String a=  new Wdgjtradelistget().httpPostString(list.get(i).toString(),tokens[i]);
      map= JSON.parseObject(a,Map.class);
      System.out.println(a);
    }



   /* List list=(List) map.get("datalist");

    System.out.println(list.size());*/

  }


}
