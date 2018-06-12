package com.diamond.model.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Author tom
 * @Date 2018-06-11 15:20
 */
@Data
@Slf4j(topic = "tradeLog")
public class KingdeeProduct {

  private int id;
  @Size(max = 35)
  private String productCode;
  @Size(max = 35)
  private String productName;
  @Size(max = 35)
  private String productCategories1;
  @Size(max = 35)
  private String productCategories2;
  @Size(max = 50)
  private String productCategories3;
  @Size(max = 6)
  private String productType;
  @Size(max = 10)
  private String specification;
  private BigDecimal expirationDate;
  @Size(max = 10)
  private String unit;
  @Size(max = 20)
  private String barCode;
  private BigDecimal packingNumber;
  private BigDecimal volume;
  private BigDecimal grossWt;
  @Size(max = 20)
  private String mainSuppliers;
  private String reservedField1;
  private String reservedField2;
  private String reservedField3;
  public void setDto(String str,int row){

    String[] products=str.split("\t");
    this.productCode = products[0];
    if(products[0].length()>35){
      log.info("productCode[0][{}]",row);
    }
    if(products[1].length()>35){
      log.info("productName[1][{}]",row);
    }
    if(products[2].length()>35){
      log.info("productCategories1[2][{}]",row);
    }
    if(products[3].length()>35){
      log.info("productCategories2[3][{}]",row);
    }
    if(products[4].length()>50){
      log.info("productCategories3[4][{}]",row);
    }
    if(products[5].length()>6){
      log.info("productType[5][{}]",row);
    }
    if(products[6].length()>20){
      log.info("specification[6]rows[{}],length[{}]",row,products[6].length());
    }

    if(products[8].length()>10){
      log.info("unit[8][{}]",row);
    }
    if(products[9].length()>20){
      log.info("barCode[9][{}]",row);
    }
    if(products.length==14) {
      if (products[13].length() > 20) {
        log.info("productName[13][{}]", row);
      }
    }
    this.productName = products[1];
    this.productCategories1 = products[2];
    this.productCategories2 = products[3];
    this.productCategories3 = products[4];
    this.productType = products[5];
    this.specification = products[6];
    this.expirationDate = getBigDecimal(products[7],"保质期 7");
    this.unit = products[8];
    this.barCode = products[9];
    this.packingNumber = getBigDecimal(products[10],"箱规10");
    this.volume = getBigDecimal(products[11],"体积11");
    this.grossWt = getBigDecimal(products[12],"箱重12");
    if(products.length>=14){
      this.mainSuppliers = products[13];
    }
   // System.out.println(row);
  }
  public BigDecimal getBigDecimal(String str,String info){
    try{
      if(StringUtils.isEmpty(str)){
        //log.info(info+"字段是空的");
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
