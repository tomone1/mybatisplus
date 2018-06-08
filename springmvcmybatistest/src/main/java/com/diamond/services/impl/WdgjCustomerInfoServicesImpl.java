package com.diamond.services.impl;

import com.diamond.mapper.WdgjCustomerInfoMapper;
import com.diamond.model.dto.CustomerInfoDto;
import com.diamond.services.WdgjCustomerInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tom
 * @Date 2018-04-11 16:31
 */
/*
* http://www.jb51.net/article/91951.htm  批處理
* */
@Service
public class WdgjCustomerInfoServicesImpl implements WdgjCustomerInfoServices {
  @Autowired
  private WdgjCustomerInfoMapper wdgjCustomerInfoMapper;
  @Override
  public void saveCustomerInfo(List<CustomerInfoDto> list) {
    if(list!=null){
      wdgjCustomerInfoMapper.saveWdgjCustomerInfoBatch(list);
    }
  }
}
