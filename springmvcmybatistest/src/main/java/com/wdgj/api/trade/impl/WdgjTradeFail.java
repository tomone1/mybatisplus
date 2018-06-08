package com.wdgj.api.trade.impl;

import com.wdgj.api.trade.WdgjReturnTradeService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author tom
 * @Date 2018-06-08 15:20
 */
@Service
public class WdgjTradeFail extends WdgjReturnTradeService {
  @Override
  public void save() {
      Contimue=false;
  }
}
