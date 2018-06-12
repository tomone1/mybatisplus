package com.diamond.mapper;

import com.diamond.model.dto.KingdeeProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by itdgyt01 on 2018-06-11.
 */
public interface KingdeeProductMapper {
  public void save(@Param("list")List<KingdeeProduct> list);
  /*
  * 商品去重
  * */
  public void distinctProduct();
  /*
    商品迁移
  * */
  public  void moveProduct();
}
