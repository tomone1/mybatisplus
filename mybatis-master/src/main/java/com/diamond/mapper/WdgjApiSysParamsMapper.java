package com.diamond.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by itdgyt01 on 2018-04-09.
 */
public interface WdgjApiSysParamsMapper {
  public  String findWdgjSysParamsByMethod(String method);
}
