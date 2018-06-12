package com.diamond.services.impl;

import com.diamond.mapper.KingdeeProductMapper;
import com.diamond.model.dto.KingdeeProduct;
import com.diamond.services.KingdeeProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tom
 * @Date 2018-06-11 16:28
 */
@Service
public class KingdeeProductServicesImpl implements KingdeeProductServices {
  @Autowired
  private KingdeeProductMapper kingdeeProductMapper;
  @Override
  public void save(List<KingdeeProduct> list) {
    kingdeeProductMapper.save(list);
  }

  @Override
  public void distinctProduct() {
    kingdeeProductMapper.distinctProduct();

  }

  @Override
  public void moveProduct() {
    kingdeeProductMapper.moveProduct();
  }
}
