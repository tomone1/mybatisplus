package com.diamond.mapper;

import com.diamond.model.dto.KingdeeAntiFakeInfo;
import com.diamond.model.dto.KingdeeProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by itdgyt01 on 2018-06-11.
 */
public interface KingdeeAntiFakeInfoMapper {
  public void save(@Param("list")List<KingdeeAntiFakeInfo> list);
  /*
  * 防伪信息去重
  * */
  public void distinctAntiFakeInfo();
  /*
    防伪信息迁移
  * */
  public  void moveAntiFakeInfo();
}
