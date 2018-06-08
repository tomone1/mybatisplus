package com.wdgj.trade;

import com.alibaba.fastjson.JSON;
import com.diamond.model.pojo.JsonTradeRootBean;
import com.diamond.services.WdgjTradeInfoServices;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author tom
 * @Date 2018-04-17 14:12
 */
@ContextConfiguration(locations = "classpath*:spring-mybatis.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TestSaveTrade {
  @Autowired
  private WdgjTradeInfoServices wdgjTradeInfoServices;
  private final static String json ="{ \"datalist\": [ { \"type\": \"\", \"tradeid\": \"2191493\", \"regtime\": \"2018/4/2 10:44:00\", \"tradetime\": \"2018/4/1 17:44:39\", \"tradestatus\": \"2\", \"tradeno\": \"52192361\", \"shopid\": \"1034\", \"shoptype\": \"天猫商城\", \"shopno\": \"\", \"shopname\": \"森田药妆官方旗舰店\", \"warehouseid\": \"1020\", \"warehousename\": \"乔杉尚仕嘉上海仓\", \"seller\": \"\", \"tradetype\": \"零售业务\", \"customerid\": \"1536703\", \"sndto\": \"瓜子\", \"country\": \"\", \"province\": \"山东省\", \"city\": \"济南市\", \"town\": \"历下区\", \"adr\": \"山东省 济南市 历下区 舜华路街道新泺大街1166号 奥盛大厦2号楼 13层\", \"zip\": \"250013\", \"tel\": \"15169121836\", \"regoperator\": \"小蒋\", \"confirmoperator\": \"\", \"picker\": \"\", \"chkoperator\": \"\", \"packageoperator\": \"\", \"sndoperator\": \"\", \"goodsweight\": \"0.0000\", \"packagedweight\": \"0.0000\", \"customerremark\": \"\", \"remark\": \"\", \"logisticid\": \"1002\", \"logisticname\": \"圆通快递\", \"postage\": \"0.00\", \"postid\": \"\", \"chargetype\": \"担保交易\", \"chargeid\": \"2018040121001001880573276876\", \"othercost\": \"0.00\", \"goodstotal\": \"108.00\", \"postagetotal\": \"0.00\", \"taxvalue\": \"0.00\", \"couponvalue\": \"0.00\", \"favourabletotal\": \"6.65\", \"alltotal\": \"101.35\", \"rcvtotal\": \"0.00\", \"currencytype\": \"本币\", \"currencyrate\": \"1.00\", \"totalprofit\": \"0.00\", \"pricespec\": \"\", \"pricedis\": \"1.0000\", \"commissionvalue\": \"0.00\", \"binvoice\": \"False\", \"invoicetitle\": \"\", \"providerid\": \"0\", \"freezereason\": \"等确认\", \"cancelreason\": \"\", \"tradefrom\": \"API\", \"tradeno2\": \"130553277856282739\", \"tradenick\": \"而小已\", \"idcard\": \"\", \"reserved1\": \"\", \"reserved2\": \"\", \"reserved3\": \"\", \"reserved4\": \"\", \"goodslist\": [ { \"barcode\": \"6954532404079\", \"goodsname\": \"森田 drjou玻尿酸集中保湿黑面膜5入\", \"goodsno\": \"6954532404079\", \"price\": \"226.0000\", \"unit\": \"盒\", \"specname\": \"5入\", \"remark\": \"\", \"goodsmoney\": \"108.00\", \"goodscount\": \"1.0000\", \"recid\": \"9087504\", \"bfit\": \"False\", \"bgift\": \"False\", \"goodsid\": \"2975\", \"specid\": \"0\", \"goodstaxprice\": 0.0, \"goodstaxrate\": 0.0, \"goodstaxamount\": 0.0, \"goodspricetaxamount\": 0.0, \"hastaxflag\": 0 } ] } ], \"returncode\": \"0\", \"returninfo\": \"1\" }\n";

  public static void main(String[] args) {

  }
  @Test
  public void test(){
    JsonTradeRootBean jsonTradeRootBean= JSON.parseObject(json,JsonTradeRootBean.class);
    wdgjTradeInfoServices.saveTradeInfo(jsonTradeRootBean.getDatalist());
  }
}
