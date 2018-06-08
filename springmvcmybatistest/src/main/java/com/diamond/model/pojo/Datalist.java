/**
  * Copyright 2018 bejson.com 
  */
package com.diamond.model.pojo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-04-16 16:54:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Datalist {

    private String type;
    private String tradeid;
    private Date regtime;
    private Date tradetime;
    private String tradestatus;
    private String tradeno;
    private String shopid;
    private String shoptype;
    private String shopno;
    private String shopname;
    private String warehouseid;
    private String warehouseno;
    private String warehousename;
    private String seller;
    private String tradetype;
    private String customerid;
    private String sndto;
    private String country;
    private String province;
    private String city;
    private String town;
    private String adr;
    private String zip;
    private String tel;
    private String regoperator;
    private String confirmoperator;
    private String picker;
    private String chkoperator;
    private String packageoperator;
    private String sndoperator;
    private String goodsweight;
    private String packagedweight;
    private String customerremark;
    private String remark;
    private String logisticid;
    private String postage;
    private String postid;
    private String chargetype;
    private String chargeid;
    private String othercost;
    private String goodstotal;
    private String postagetotal;
    private String taxvalue;
    private String couponvalue;
    private String favourabletotal;
    private String alltotal;
    private String rcvtotal;
    private String currencytype;
    private String currencyrate;
    private String totalprofit;
    private String pricespec;
    private String pricedis;
    private String commissionvalue;
    private String binvoice;
    private String invoicetitle;
    private String providerid;
    private String freezereason;
    private String cancelreason;
    private String tradefrom;
    private String tradeno2;
    private String tradenick;
    private String reserved1;
    private String reserved2;
    private String reserved3;
    private String reserved4;
    private List<Goodslist> goodslist;

}