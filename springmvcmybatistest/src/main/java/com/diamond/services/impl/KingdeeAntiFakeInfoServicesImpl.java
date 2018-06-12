package com.diamond.services.impl;

import com.diamond.mapper.KingdeeAntiFakeInfoMapper;
import com.diamond.model.dto.KingdeeAntiFakeInfo;
import com.diamond.services.KingdeeAntiFakeInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tom
 * @Date 2018-06-11 16:28
 */
@Service
public class KingdeeAntiFakeInfoServicesImpl implements KingdeeAntiFakeInfoServices {
  @Autowired
  private KingdeeAntiFakeInfoMapper kingdeeAntiFakeInfoMapper;

  @Override
  public void save(List<KingdeeAntiFakeInfo> list) {
    kingdeeAntiFakeInfoMapper.save(list);
  }

  @Override
  public void distinctAntiFakeInfo() {
    kingdeeAntiFakeInfoMapper.distinctAntiFakeInfo();
  }
  @Override
  public void moveAntiFakeInfo() {
    kingdeeAntiFakeInfoMapper.moveAntiFakeInfo();
  }
}
