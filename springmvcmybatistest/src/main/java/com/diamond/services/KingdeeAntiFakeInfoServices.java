package com.diamond.services;

import com.diamond.model.dto.KingdeeAntiFakeInfo;
import java.util.List;

/**
 * @Author tom
 * @Date 2018-06-11 16:25
 */

public interface KingdeeAntiFakeInfoServices {
  public void save(List<KingdeeAntiFakeInfo> list);
  /*
  * 防伪信息去重
  * */
  public void distinctAntiFakeInfo();
  /*
    防伪信息迁移
  * */
  public  void moveAntiFakeInfo();
}
