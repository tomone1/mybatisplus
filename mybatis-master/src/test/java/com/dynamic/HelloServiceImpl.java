package com.dynamic;

/**
 * @Author tom
 * @Date 2018/3/21 14:50
 */

public class HelloServiceImpl implements HelloService {
  @Override
  public void sayHello(String name) {
    System.out.println("hello " +name);
  }
}
