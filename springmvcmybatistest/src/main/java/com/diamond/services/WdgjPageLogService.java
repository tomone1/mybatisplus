package com.diamond.services;

import java.util.List;
import java.util.Map;

/**
 * Created by itdgyt01 on 2018-04-17.
 */
public interface WdgjPageLogService {
  public void save(Map map);
  public void saveTradeErrorLog(Map map);
  public List<Map<String,Object>> find(String  method);
}
