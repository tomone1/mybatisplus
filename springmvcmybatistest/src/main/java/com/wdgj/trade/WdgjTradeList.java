package com.wdgj.trade;

import com.alibaba.fastjson.JSON;
import com.diamond.services.WdgjApiSysParamsServices;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.util.Common;
import com.util.HttpUtil;
import com.wdgj.cach.SysParamCache;
import com.wdgj.util.WdgjInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-04-17 11:16
 */
@Service
@Slf4j(topic = "tradeLog")
public class WdgjTradeList {

  @Autowired
  private SysParamCache SysParamCache;
  @Value("${apiurl}")
  private String apiurl;
  @Value("${appkey}")
  private String appkey;
  private Map<String, String> dic;
 // private final static  String method="wdgj.trade.list.get";
/*
* 0：未归档订单，1查询已归档订单
* */
  public String httpPostString(Map<String,Object> map)

      throws Exception {

    dic = new HashMap<>();

    dic=SysParamCache.getSysparams(appkey);
    log.info(""+JSON.toJSON(dic));
    dic.put(WdgjInfoUtil.TIMESTAMP, Long.toString(System.currentTimeMillis() / 1000));

    dic.put(WdgjInfoUtil.METHOD, map.get(WdgjInfoUtil.METHOD).toString());

    //添加应用级参数

    //非必须参数如果不传值需要删除该行

    dic.put(WdgjInfoUtil.SEARCHTYPE, map.get(WdgjInfoUtil.SEARCHTYPE).toString());//参数searchtype的值，类型string，必须

    dic.put(WdgjInfoUtil.BEGINTIME, map.get(WdgjInfoUtil.BEGINTIME).toString());//参数begintime的值，类型String，必须

    dic.put(WdgjInfoUtil.ENDTIME, map.get(WdgjInfoUtil.ENDTIME).toString());//参数endtime的值，类型String，必须

    dic.put(WdgjInfoUtil.PAGENO, map.get(WdgjInfoUtil.PAGENO).toString());//参数pageno的值，类型String，必须

    dic.put(WdgjInfoUtil.PAGESIZE, "100");//参数pagesize的值，类型String，必须

    dic.put(WdgjInfoUtil.TIMETYPE, "0");//参数timetype的值，类型string，非必须

    dic.put(WdgjInfoUtil.SEARCHSTATUS, "");//参数searchstatus的值，类型string，非必须

    dic.put(WdgjInfoUtil.SEARCHNO, "");//参数searchno的值，类型string，非必须

    dic.put(WdgjInfoUtil.RELATIONNO, "");//参数relationno的值，类型string，非必须

    dic.put(WdgjInfoUtil.WAREHOUSENO, "");//参数warehouseno的值，类型string，非必须
    dic.put(WdgjInfoUtil.ACCESSTOKEN,map.get(WdgjInfoUtil.ACCESSTOKEN).toString());
    //计算sign
    String appsecret=dic.get(WdgjInfoUtil.APPSECRET);
    dic.remove(WdgjInfoUtil.APPSECRET);
    String sign = Common.getSign(appsecret, dic);
    //dic.put("appsecret",appsecret);
    dic.put(WdgjInfoUtil.SIGN, sign);

    //将字典类型的参数转成x-www-form-urlencoded的形式

    String poststr = Common.ChangeToPostValue(dic);
    poststr="a=&"+poststr;
    log.info("请求参数"+poststr);

    //发送post请求

    return HttpUtil.doPostRequest(apiurl, poststr);

  }



}
