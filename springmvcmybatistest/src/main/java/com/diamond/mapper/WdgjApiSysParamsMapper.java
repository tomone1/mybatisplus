package com.diamond.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by itdgyt01 on 2018-04-09.
 */
public interface WdgjApiSysParamsMapper {
  public List<Map<String,Object>> findWdgjSysParamsByMethod(@Param("appkey") String appkey);
  public void updateStatusToIsAll(@Param("method") String method,@Param("status")String status);

}
