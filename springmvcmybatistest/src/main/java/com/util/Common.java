package com.util;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.*;

/**
 * @Author tom
 * @Date 2018/3/22 14:56
 */

public class Common {


  //生成签名
  public static String getSign(String AppSecret,Map<String ,String> paraMap)throws Exception {
    Iterator iter = paraMap.entrySet().iterator();
    List<String> list = new ArrayList<>();
   // String AppSecret =null;
    while (iter.hasNext()) {
      Map.Entry entry = (Map.Entry) iter.next();
      String val = entry.getValue().toString();
      list.add(val);
    }
    //ASCII码排序
    Collections.sort(list, new Comparator<String>() {
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    });
    StringBuilder builder = new StringBuilder();
    //参数拼接
    builder.append(AppSecret);
    for (String value : list) {
      builder.append(value);
    }
    builder.append(AppSecret);
    //md5加密后得到最终的签名
    return getMd5Value(builder.toString());
  }
  //自己处理一下md5加密，原生的md5加密方法有问题
  public static String getMd5Value(String sSecret) throws Exception {
    MessageDigest bmd5 = MessageDigest.getInstance("MD5");
    bmd5.update(sSecret.getBytes("UTF-8"));
    int i;
    StringBuffer buf = new StringBuffer();
    byte[] b = bmd5.digest();
    for (int offset = 0; offset < b.length; offset++) {
      i = b[offset];
      if (i < 0)
        i += 256;
      if (i < 16)
        buf.append("0");
      buf.append(Integer.toHexString(i));
    }
    return buf.toString();
  }
  public static String ChangeToPostValue(Map<String, String> dicIn)
  {
    StringBuilder sb = new StringBuilder();
    for (String s : dicIn.keySet()) {
      sb.append(s+"="+ URLEncoder.encode(dicIn.get(s))+"&");
    }

    if (sb.length()> 0)
    {

      sb =sb.delete(sb.length()-1,sb.length());
    }
    return ""+sb.toString();
  }


}
