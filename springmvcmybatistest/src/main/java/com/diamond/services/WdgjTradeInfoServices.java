package com.diamond.services;

import com.diamond.model.dto.WdgjTradeInfo;
import com.diamond.model.dto.WdgjTradeItemInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by itdgyt01 on 2018-04-17.
 */
public interface WdgjTradeInfoServices {
  public void saveTradeInfo(List<WdgjTradeInfo> list);
//
   public void trunctateWdgjTradeInfo();
//  public void saveWdgjTradeInfo(@Param("list") List<WdgjTradeInfo> list);
//  public void saveWdgjTradeIntemInfo(@Param("list") List<WdgjTradeItemInfo> list);
  public void distinctTrade();
  public void moveTrade();
  public void distinctCustomer();
  public void moveCustomer();
  public void updateCustomerInfo();

}
