package com.shentian;

import org.omg.IOP.Encoding;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.*;

/**
 * @Author tom
 * @Date 2018/3/22 14:56
 */

public class Common {
/*  public static String getSign(String appSecret, Dictionary<String, String> dicIn)
  {
  public static string getSign(string appSecret, Dictionary<string, string> dicIn)
        {
            List<string> listString = new List<string>();
            string sign = string.Empty;
            string versions = string.Empty;
            foreach (var item in dicIn)
            {
                if (item.Key.ToLower() == "versions")
                {
                    versions = item.Value;
                }
                if (!string.IsNullOrWhiteSpace(item.Value))
                    listString.Add(item.Value);
            }
            if (string.IsNullOrEmpty(versions) || versions == "1.0" || versions == "1")
            {
                //字典排序
                listString.Sort();
            }
            else
            {
                //ASCII码排序
                listString.Sort(StringComparer.Ordinal);
            }
            string tmpStr = appSecret + string.Join("", listString) + appSecret;
            return System.Web.Security.FormsAuthentication.HashPasswordForStoringInConfigFile(tmpStr, "MD5").ToLower();
        }


  }*/
  //收集签名需要的参数
  public static Map<String, Object> getMap() {
    long timestamp =System.currentTimeMillis() / 1000;
    HashMap<String, Object> map = new HashMap<>();
    map.put("accesstoken", "b6e5f1bd8cf34fa1a60ba696f30a4ee6");
    map.put("appkey", "07645036");
    map.put("timestamp", timestamp);
    map.put("versions", "1.1");
    map.put("format","xml");
    map.put("page_no","1");
    map.put("page_size","50");
    map.put("begin_time","2016-07-25 00:00:00");
    map.put("end_time","2016-07-26 11:00:33");
    map.put("content","<trade_order_info><trade_order></trade_order></trade_order_info>");
    //map.put（除appsecret参数外的所有系统级参数和应用级级参数值，根据每个方法需要传的参数）
    return map;
  }
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

  public static void main(String[] args) {
    StringBuilder a=new StringBuilder("122333@@@9o");
    a=a.delete(a.length()-1,a.length());
    System.out.println(a.toString());
  }
  public static String HttpPost(String url, String paramStr)
  {
    String fullUrl = url;
    String resStr = "";
   /* try
    {
      byte[] bs = Encoding.UTF8.GetBytes(paramStr);
      HttpWebRequest request = (HttpWebRequest)HttpWebRequest.Create(fullUrl);

      request.Method = "POST";
      request.ContentType = "application/x-www-form-urlencoded;charset=UTF8";
      request.ContentLength = bs.Length;
      request.Proxy = null;
      request.Timeout = 30000;
      request.KeepAlive = true;
      using (Stream reqStream = request.GetRequestStream())
      {
        reqStream.Write(bs, 0, bs.Length);
      }
      HttpWebResponse response = (HttpWebResponse)request.GetResponse();
      StreamReader reader = new StreamReader(response.GetResponseStream(), Encoding.UTF8);

      resStr = reader.ReadToEnd();
      reader.Close();
    }
    catch (System.Exception err)
    {
      resStr = err.Message;
    }*/
    return resStr;
  }
}
