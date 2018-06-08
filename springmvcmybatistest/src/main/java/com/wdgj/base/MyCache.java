package com.wdgj.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-04-13 19:43
 */

public class MyCache {

  private static final String method = "wdgj.customer.member.list";
  private static final String accesstoken = "44f7d7feed1446ef86fcfdc300ed1ddc";
  private static final String appsecret = "4bf1h386ibhkki90hag4b7gdldfdo6m5";
  private static final String appkey = "26353827";
  private static final String sign = "";
  private static final String timestamp = "";
  private static final String format = "json";
  private static final String versions = "1.0";

  private static MyCache myCache=null;
  private static Map<String, String> pathMap = new HashMap<String, String>(){


    /**
     * 给Map初始化、赋值
     */
    private static final long serialVersionUID = 8215851505074905693L;
    {
      put("method",method);
      put("accesstoken",accesstoken);
      put("appsecret",appsecret);
      put("appkey",appkey);
      put("sign",sign);
      put("timestamp",timestamp);
      put("format",format);
      put("versions",versions);


    }
  };

  /**
   * 
   * @return 返回该Map
   */
  public static MyCache getMyCache(){
    if(myCache==null){
      myCache=new MyCache();
    }
    return myCache;

  }

  public static String getMethod() {
    return method;
  }

  public static String getAccesstoken() {
    return accesstoken;
  }

  public static String getAppsecret() {
    return appsecret;
  }

  public static String getAppkey() {
    return appkey;
  }

  public static String getSign() {
    return sign;
  }

  public static String getTimestamp() {
    return timestamp;
  }

  public static String getFormat() {
    return format;
  }

  public static String getVersions() {
    return versions;
  }

  public static Map<String, String> getPathMap() {
    return pathMap;
  }

  public static void setPathMap(Map<String, String> pathMap) {
    MyCache.pathMap = pathMap;
  }
}
