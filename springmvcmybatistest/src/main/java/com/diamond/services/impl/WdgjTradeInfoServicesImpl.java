package com.diamond.services.impl;

import com.diamond.mapper.WdgjTradeInfoMapper;
import com.diamond.model.dto.WdgjTradeInfo;
import com.diamond.model.dto.WdgjTradeItemInfo;
import com.diamond.services.WdgjTradeInfoServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin2.main.client.WDonatePrivilege;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tom
 * @Date 2018-04-17 14:40
 */
@Service
@Slf4j(topic = "tradeLog")
@Transactional
public class WdgjTradeInfoServicesImpl implements WdgjTradeInfoServices{
  @Autowired
  private WdgjTradeInfoMapper wdgjTradeInfoMapper;
  @Transactional
  public void saveTradeInfo(List<WdgjTradeInfo>list){
    wdgjTradeInfoMapper.trunctateWdgjTradeInfo();
    wdgjTradeInfoMapper.saveWdgjTradeInfo(list);
    List<WdgjTradeItemInfo> listItem=new ArrayList<>();
    for (int i = 0; i <list.size() ; i++) {
      if(list.get(i).getGoodslist()!=null){
        listItem.addAll(list.get(i).getGoodslist());
      }else{
        log.info("订单号{}的商品详情为null",list.get(i).getTrade_no());
      }


    }
    if(listItem.size()>0){
      wdgjTradeInfoMapper.saveWdgjTradeIntemInfo(listItem);
    }

    wdgjTradeInfoMapper.distinctTrade();
    wdgjTradeInfoMapper.moveTrade();
    wdgjTradeInfoMapper.distinctCustomer();
    wdgjTradeInfoMapper.moveCustomer();
    wdgjTradeInfoMapper.updateCustomerInfo();
  }

  @Override
  public void trunctateWdgjTradeInfo() {
    wdgjTradeInfoMapper.trunctateWdgjTradeInfo();
  }

  @Override
  public void distinctTrade() {
    wdgjTradeInfoMapper.distinctTrade();
  }

  @Override
  public void moveTrade() {
    wdgjTradeInfoMapper.moveTrade();
  }

  @Override
  public void distinctCustomer() {
    wdgjTradeInfoMapper.distinctCustomer();
  }

  @Override
  public void moveCustomer() {
    wdgjTradeInfoMapper.moveCustomer();
  }

  @Override
  public void updateCustomerInfo() {
    wdgjTradeInfoMapper.updateCustomerInfo();
  }
}
