package com.diamond.pojo;

import lombok.Data;

/**
 * @Author tom
 * @Date 2018/3/26 15:33
 */
@Data
public class Person {
  private int id;
  private String name;
  @Override
  public String toString() {
    return "id : " + id + " name : " + name;
  }
}
