package com.diamond.mapper;

import com.diamond.pojo.User;

/**
 * @Author tom
 * @Date 2018/3/20 16:07
 */

public interface UserMapper {
  /*
  *  方法和UserMapper.xml 保持一致
  * */
  public User findUserById(int id);
}
