package com.diamond.services.impl;

import com.diamond.mapper.WdgjApiSysParamsMapper;
import com.diamond.services.WdgjApiSysParamsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-04-09 16:05
 */
@Service
public class WdgjApiSysParamsServicesImpl  implements WdgjApiSysParamsServices{

  @Autowired
  private WdgjApiSysParamsMapper mapper;
  public Map findWdgjApiSysParams(String appkey) {
    List<Map<String,Object>> lsit=new ArrayList<>();
    lsit=mapper.findWdgjSysParamsByMethod(appkey);
    if(lsit.isEmpty()){
      return  new HashMap();
    }
    return  lsit.get(0);
  }
}
