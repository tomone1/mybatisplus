package com.diamond.services;

import com.diamond.model.dto.CustomerInfoDto;

import java.util.List;

/**
 * @Author tom
 * @Date 2018-04-11 16:31
 */

public interface WdgjCustomerInfoServices {
  public void saveCustomerInfo(List<CustomerInfoDto> list);
}
