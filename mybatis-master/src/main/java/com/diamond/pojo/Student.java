package com.diamond.pojo;

import lombok.Data;

/**
 * @Author tom
 * @Date 2018/3/15 15:26
 */
/*学生
* */
@Data
public class Student extends BaseModel{
 /*
 * 编号
 * */
// private int id;
 /*
  学生姓名
 * */
 private String cname;
 /*
 * 性别
 * */
 private String sex;
 /*
 * 学生证号
 * */
 private  String selfcardNo;
 /*
 * 备注
 * */
// private  String note;
}
