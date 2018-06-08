package com.diamond.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by itdgyt01 on 2018-04-17.
 */
public interface WdgjPageLogMapper {
  void updatePageLog(Map map);
  void saveTradeErrorLog(Map map);
  List<Map<String,Object>> findPageLogByMethod(@Param("method") String method);

}
