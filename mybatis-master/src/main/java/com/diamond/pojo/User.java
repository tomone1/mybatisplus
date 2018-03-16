package com.diamond.pojo;

import lombok.Data;

/**
 * @Author tom
 * @Date 2018/3/15 15:18
 */
/*
*用户
* */
@Data
public class User extends BaseModel {

  /*
  *  用户名称
  * */
  private  String userName;
  /*
  * 姓名
  * */
  private  String cname;
  /*
   性别
  * */
  private  int sex;
  /*
  * 手机号码
  * */
  private  String mobile;
  /*
  * 电子邮件
  * */
  private String email;


}
