package com.wdgj.cach;

import com.diamond.services.WdgjApiSysParamsServices;
import com.wdgj.util.WdgjInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-05-03 16:40
 */
@Service
public class SysParamCache {
  @Autowired
  private WdgjApiSysParamsServices wdgjApiSysParamsServices;
  public final Map getSysparams(String appkey){
    Object o=CacheMap.get(appkey);
    Map map=new HashMap();
    if(o==null){
       map=wdgjApiSysParamsServices.findWdgjApiSysParams(appkey);
      map.remove(WdgjInfoUtil.STATUS);
      CacheMap.put(appkey,appkey,5);
//      CacheMap.put("accesstoken",map.get("accesstoken"),5);
      CacheMap.put("appsecret",map.get("appsecret"),5);
      CacheMap.put("appkey",map.get("appkey"),5);
      CacheMap.put("format",map.get("format"),5);
      CacheMap.put("versions",map.get("versions"),5);
      return map;
    }else{
//      map.put("accesstoken",CacheMap.get("accesstoken"));
      map.put("appsecret",CacheMap.get("appsecret"));
      map.put("appkey",CacheMap.get("appkey"));
      map.put("format",CacheMap.get("format"));
      map.put("versions",CacheMap.get("versions"));

    }

    return  map;
  }
}
