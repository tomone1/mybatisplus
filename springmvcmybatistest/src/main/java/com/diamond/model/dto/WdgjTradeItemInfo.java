package com.diamond.model.dto;

import lombok.Data;

import java.util.UUID;

/**
 * @Author tom
 * @Date 2018-04-17 14:06
 */
@Data
public class WdgjTradeItemInfo {
  private String id=UUID.randomUUID().toString();;
  private String order_id;
  private String goodsno;
  private String goodsname;
  private String goodscount;
  private String price;
  private String goodsmoney;

}
