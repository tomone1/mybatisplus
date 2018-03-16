package com.diamond.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author tom
 * @Date 2018/3/15 15:47
 */
/*
* 学生编号
* */
@Data
public class StudentSelfcard extends BaseModel {
  /*
  * 学生编号'
  * */
  private  int studentId;
  /*
  籍贯
  */
  private  String tnative;
  /*发证日期
  * */
  private Date issueDate;
  /*
  * 结束日期
  * */
  private Date endDate;


}
