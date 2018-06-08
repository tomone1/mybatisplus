package com.wdgj.api.trade;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by itdgyt01 on 2018-06-08.
 */
@Data
public abstract class WdgjReturnTradeService {
  protected  boolean Contimue=true;
  protected  int continueNum=0;
  protected  int pageNo=0;
  /*
  * 工程参数*/
  protected  Map pageMap=new HashMap();//
  protected String json="";
  protected int sumNum=0;
  protected int sumSingNum=0;

  public boolean getContimue() {
    return Contimue;
  }

  public abstract void  save();
}
