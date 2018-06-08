package com.diamond.model.dto;

import com.mysql.jdbc.StringUtils;
import lombok.Data;
import org.apache.derby.iapi.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author tom
 * @Date 2018-04-17 14:04
 */
@Data
public class WdgjTradeInfo {
  private String id=UUID.randomUUID().toString();
  private String shopid;
  private String trade_no;
  private String tradeno2;
  private String tradestatus;
  private String sndto;
  private String province;
  private String city;
  private String town;
  private String adr;
  private String tel;
  private String remark;
  private String logisticlistno;
  private String logisticname;
  private String tradetime;
  private String shopname;
  private String goodstotal;
  private String tradenick;
  private List<WdgjTradeItemInfo> goodslist;

  public List<WdgjTradeItemInfo> getGoodslist() {
    return goodslist;
  }

  public void setGoodslist(List<WdgjTradeItemInfo> goodslist) {
    List<WdgjTradeItemInfo>itemInfoList=new ArrayList<>();
    for (int i = 0; i <goodslist.size() ; i++) {
      WdgjTradeItemInfo wdgjTradeItemInfo=goodslist.get(i);
      wdgjTradeItemInfo.setOrder_id(id);
      itemInfoList.add(wdgjTradeItemInfo);
    }
    this.goodslist = itemInfoList;
  }
}
