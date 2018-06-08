/**
  * Copyright 2018 bejson.com 
  */
package com.diamond.model.pojo;

import com.diamond.model.dto.CustomerInfoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Auto-generated: 2018-04-11 15:7:0
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class JsonCustomerRootBean {

    private String error_code;
    private String error_info;
    private List<CustomerInfoDto> customer_info_list=new ArrayList<>();

}