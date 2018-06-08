/*

使用方法：

1.点击上面“调用示例下载”按钮下载调用示例

2.打开上面下载的调用示例工程，新建一个类复制粘贴下面的代码

3.在主函数里面调用httpPostString方法

*/

import com.shentian.Common;
import com.shentian.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class Wdgjcustomermemberlist

{
/*  accesstoken d10c3d88bd984707bfae92c68a4fcd2e
 appkey :16843421
appsecret:407150khiekco58og526nmoda8d8cglm*/

  private Map<String, String> dic;

  private String appkey = "16843421";

  private String appsecret = "407150khiekco58og526nmoda8d8cglm";

  private String accesstoken = "d10c3d88bd984707bfae92c68a4fcd2e";

  private String apiurl = "http://api.wdgj.com/wdgjcloud/api";

  public String httpPostString() throws Exception

  {

    dic = new HashMap<>();

    //添加系统级参数

    dic.put("appkey", appkey);

    dic.put("accesstoken", accesstoken);

    dic.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));



    dic.put("versions", "1.1");//支持1.0和1.1
    dic.put("method", "wdgj.customer.member.list");
    dic.put("format", "json");//支持json和xml，如需返回json格式，替换xml为json

    //添加应用级参数 wdgj.customer.member.list

    //非必须参数如果不传值需要删除该行

    dic.put("modify_date", "2017-01-01");//参数modify_date的值，类型datetime，必须

    dic.put("page_no", "1");//参数page_no的值，类型int，必须

    dic.put("page_size", "1");//参数page_size的值，类型int，必须

    dic.put("Customer_ID", "");//参数Customer_ID的值，类型int，非必须

    dic.put("ShopID", "");//参数ShopID的值，类型int，非必须

    dic.put("SearchKey", "");//参数SearchKey的值，类型string，非必须

    //计算sign

    String sign = Common.getSign(appsecret, dic);

    dic.put("sign", sign);

    //将字典类型的参数转成x-www-form-urlencoded的形式

    String poststr = Common.ChangeToPostValue(dic);
    poststr="a=json&"+poststr;
   /* poststr="a=json&method=wdgj.customer.member.list&format=json&sign=bf1d62d5d881aa677d7bb7c8582fc401&accesstoken=65be7747b49a4060a28030dfd1c0e56f&page_no=1&versions=1.0&Customer_ID=&SearchKey=&appkey=40420831&modify_date=2017-01-01&ShopID=&timestamp=1523182741&page_size=50";*/
    System.out.println(poststr);
    //发送post请求

    return HttpUtil.doPostRequest(apiurl, poststr);

  }

  public static void main(String[] args)throws Exception {
    String a=new Wdgjcustomermemberlist().httpPostString();
    System.out.println(a);
  }
}