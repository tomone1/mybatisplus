package com.diamond.services;


import com.diamond.model.dto.KingdeeProduct;

import java.util.List;

/**
 * Created by itdgyt01 on 2018-06-11.
 */
public interface KingdeeProductServices {
  public void save(List<KingdeeProduct> list);
  /*
  * 商品去重
  * */
  public void distinctProduct();
  /*
    商品迁移
  * */
  public  void moveProduct();
}
