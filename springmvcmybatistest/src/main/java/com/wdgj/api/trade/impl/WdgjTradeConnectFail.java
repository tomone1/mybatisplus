package com.wdgj.api.trade.impl;

import com.wdgj.api.trade.WdgjReturnTradeService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author tom
 * @Date 2018-06-08 15:16
 */
@Data
@Service
public class WdgjTradeConnectFail extends  WdgjReturnTradeService {

  @Override
  public void save() {
    continueNum++;
    if(continueNum>2){
      Contimue=false;
    }
  }
}
