/**
  * Copyright 2018 bejson.com 
  */
package com.diamond.model.pojo;
import com.alibaba.fastjson.JSONObject;
import com.diamond.model.dto.WdgjTradeInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Auto-generated: 2018-04-16 16:54:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
@Slf4j(topic = "tradeLog")
public class JsonTradeRootBean {

    private List<WdgjTradeInfo> datalist=new ArrayList<>();
    private String returncode;
    private String returninfo;

    public List<WdgjTradeInfo> getDatalist(String shopId) {
       String[] shopIds=shopId.split(",");
        List<WdgjTradeInfo> list=new ArrayList<>();
        for (WdgjTradeInfo wdgjTradeInfo:datalist){
            if (Arrays.asList(shopIds).contains(wdgjTradeInfo.getShopid())){
                list.add(wdgjTradeInfo);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new JsonTradeRootBean().getDatalist("[{\"shopId\": \"1034\"}]");
    }

}