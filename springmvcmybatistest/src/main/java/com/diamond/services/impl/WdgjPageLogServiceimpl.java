package com.diamond.services.impl;

import com.diamond.mapper.WdgjPageLogMapper;
import com.diamond.services.WdgjPageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author tom
 * @Date 2018-04-17 18:12
 */
@Service
public class WdgjPageLogServiceimpl implements WdgjPageLogService {
  @Autowired
  private WdgjPageLogMapper wdgjPageLogMapper;
  @Override
  public void save(Map map) {
    wdgjPageLogMapper.updatePageLog(map);

  }

  @Override
  public List<Map<String,Object>> find(String method) {
    return wdgjPageLogMapper.findPageLogByMethod(method);

  }

  @Override
  public void saveTradeErrorLog(Map map) {
    wdgjPageLogMapper.saveTradeErrorLog(map);
  }
}
