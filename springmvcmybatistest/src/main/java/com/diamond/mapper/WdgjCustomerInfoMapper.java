package com.diamond.mapper;

import com.diamond.model.dto.CustomerInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by itdgyt01 on 2018-04-11.
 */
public interface WdgjCustomerInfoMapper {
public void saveWdgjCustomerInfoBatch(@Param("list") List<CustomerInfoDto> list);

}
