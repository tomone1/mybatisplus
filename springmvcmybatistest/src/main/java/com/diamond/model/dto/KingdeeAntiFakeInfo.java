package com.diamond.model.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;

/**
 * @Author tom
 * @Date 2018-06-11 15:14
 */
/*
 防伪信息查询你
* */
@Data
@Slf4j
public class KingdeeAntiFakeInfo {
  private int id;
  private BigDecimal antFakeCode;
  private String memberUnionId;
  private String memberOpenID;
  private String queryDate;
  private BigDecimal boxBarcode;
  private BigDecimal cartonBarCode;
  private String productCode;
  private String productName;
  private BigDecimal barCode;
  private String batchNo;
  private String expireDate;
  private String customerDate;
  private String sellOrderNo;
  private String reservedField1;
  private String reservedField2;
  private String reservedField3;

  public void setDto(String str,int row){

    String[] antiFake=str.split("\t");
    this.antFakeCode = getBigDecimal(antiFake[0],"防伪码0");
    this.memberUnionId = antiFake[1];
    this.memberOpenID = antiFake[2];
    this.queryDate = antiFake[3];
    this.boxBarcode = getBigDecimal(antiFake[4],"盒条码4");
    this.cartonBarCode = getBigDecimal(antiFake[5],"箱条码5");
    this.productCode = antiFake[6];
    this.productName = antiFake[7];
    if(antiFake.length>=9){
      this.barCode = getBigDecimal(antiFake[8],"条形码8");
    }
    if(antiFake.length>=10){
      this.batchNo = antiFake[9];
    }
    if(antiFake.length>=11){
       this.expireDate = antiFake[10];
    }
    if(antiFake.length>=12){
     this.customerDate = antiFake[11];
    }
    if(antiFake.length>=13){
      this.sellOrderNo = antiFake[12];
    }

  }



  public BigDecimal getBigDecimal(String str, String info){
    try{
      if(StringUtils.isEmpty(str)){
        log.info(info+"字段是空的");
        return new BigDecimal(0);
      }else{
        return new BigDecimal(str);
      }
    }catch(Exception e){
      log.error(info+"字段不是数字类型 非法字符"+e);
      return null;
    }

  }


}
