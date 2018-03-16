package com.diamond.pojo;

import lombok.Data;

/**
 * @Author tom
 * @Date 2018/3/15 15:34
 */
/*
* 男学生健康信息
* */
@Data
public class StudentHealthMale extends BaseModel{
  /*
  * 学生编号
  * */
  private String studentId;
  /*
  * 检查日期
  * */
  private String checkDate;
  /*
  * 心
  * */
  private  String heart;
  /*
  * 肝
  * */
  private String liver;

  /*
  * 脾*/
  private  String spleen;
  /*
  * 肺
  * */
  private String lung;
  /*
  * 肾
  * */
  private String kidney;
  /*
  * 前列腺
  * */
  private String prostate;

}