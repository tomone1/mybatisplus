package com.diamond.model.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
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
    if (antiFake.length>=1){
      this.antFakeCode = getBigDecimal(antiFake[0],"防伪码0");
    }
    if (antiFake.length>=2){
      this.memberUnionId = getString(antiFake[1]);
    }
    if (antiFake.length>=3){
      this.memberOpenID = getString(antiFake[2]);
    }
    if (antiFake.length>=4){
      this.queryDate = getString(antiFake[3]);
    }
    if (antiFake.length>=5){
      this.boxBarcode = getBigDecimal(antiFake[4],"盒条码4");
    }
    if (antiFake.length>=6){
      this.cartonBarCode = getBigDecimal(antiFake[5],"箱条码5");
    }
    if (antiFake.length>=7){
      this.productCode = getString(antiFake[6]);
    }
    if(antiFake.length>=8){
      this.productName = getString(antiFake[7]);
    }
    if(antiFake.length>=9){
      this.barCode = getBigDecimal(antiFake[8],"条形码8");
    }
    if(antiFake.length>=10){
      this.batchNo = getString(antiFake[9]);
    }
    if(antiFake.length>=11){
       this.expireDate = getString(antiFake[10]);
    }
    if(antiFake.length>=12){
     this.customerDate = getString(antiFake[11]);
    }
    if(antiFake.length>=13){
      this.sellOrderNo = getString(antiFake[12]);
    }

  }



  public BigDecimal getBigDecimal(String str, String info){
    try{
      if(StringUtils.isEmpty(str)){
        log.info(info+"字段是空的");
        return new BigDecimal(0);
      }else if("NULL".equals(str)){
        return null;
      }else{
        return new BigDecimal(str);

      }
    }catch(Exception e){
      log.error(info+"[{}]字段不是数字类型 非法字符"+e,str);
      return null;
    }

  }
  public String getString(String str){
    if("NULL".equals(str)){
      return null;
    }else{
      return str;
    }
  }
}
