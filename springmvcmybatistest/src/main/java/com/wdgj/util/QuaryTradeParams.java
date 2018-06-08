package com.wdgj.util;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author tom
 * @Date 2018-06-06 15:28
 */
@Data
public class QuaryTradeParams {
  private int pageNo;
  private int searchtype;
  private String begintime;
  private String endtime;
  private String accesstoken;
  private String method;

  public QuaryTradeParams(Map<String,Object> map) {
    Optional<Map> optional=Optional.ofNullable(map);
    this.pageNo=1;
    if(optional.isPresent()){
      if(optional.get().get(WdgjInfoUtil.PAGENO)!=null){
        this.pageNo=Integer.parseInt(optional.get().get(WdgjInfoUtil.PAGENO).toString());
      }
      if(optional.get().get(WdgjInfoUtil.BEGINTIME)!=null){
        this.begintime=optional.get().get(WdgjInfoUtil.BEGINTIME).toString();
      }else {
        this.begintime= LocalDate.now().toString();
      }
      if(optional.get().get(WdgjInfoUtil.ENDTIME)!=null){
        this.endtime=optional.get().get(WdgjInfoUtil.ENDTIME).toString();
      }else{
        this.endtime=LocalDate.now().toString();
      }
      if(optional.get().get(WdgjInfoUtil.SEARCHTYPE)!=null){
      this.searchtype=Integer.parseInt(optional.get().get(WdgjInfoUtil.SEARCHTYPE).toString());
      }else{
        this.searchtype=0;
      }

      if(optional.get().get(WdgjInfoUtil.ACCESSTOKEN)!=null){
      this.accesstoken=optional.get().get(WdgjInfoUtil.ACCESSTOKEN).toString();
      }else{
        this.accesstoken="";
      }
      if(optional.get().get(WdgjInfoUtil.METHOD)!=null){
      this.method=optional.get().get(WdgjInfoUtil.METHOD).toString();
      }else{
        this.method="";
      }

    }
  }

  public Map<String,Object> getParams(){
    Map<String,Object> map=new HashMap<>();
    map.put(WdgjInfoUtil.PAGENO,pageNo);
    map.put(WdgjInfoUtil.SEARCHTYPE,searchtype);
    map.put(WdgjInfoUtil.BEGINTIME,begintime);
    map.put(WdgjInfoUtil.ENDTIME,endtime);
    map.put(WdgjInfoUtil.ACCESSTOKEN,accesstoken);
    map.put(WdgjInfoUtil.METHOD,method);
    return map;
  }
}
