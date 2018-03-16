package com.diamond.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author tom
 * @Date 2018/3/15 15:42
 */
/*
* 学生课程关联表
* */
@Data
public class StudentLecture extends BaseModel{
  /*
  * 学生编号
  * */
  private int studentId;
  /*
  * 课程编号
  * */
  private int lectureId;
  /*
  * 评分
  * */
  private BigDecimal grade;


}
