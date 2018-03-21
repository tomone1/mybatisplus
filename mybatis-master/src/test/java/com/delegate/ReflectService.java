package com.delegate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author tom
 * @Date 2018/3/20 17:29
 */

public class ReflectService{
  /*
  * 服务方法
  * */
  public  void  sayHollo(String name){
    System.out.println("hello "+name);
  }

  public static void main(String[] args)throws  ClassNotFoundException ,InvocationTargetException,InstantiationException,IllegalAccessException,NoSuchMethodException {
  /*
  * 通过反射创建ReflectService 对象
  *
  * */
    Object service = Class.forName("com.delegate.ReflectService").newInstance();


  /*
  * 获取服务方法
  * */
    Method method = service.getClass().getMethod("sayHollo", String.class);
    /*
    * 反射调用方法
    * */
    method.invoke(service, "葛永涛");
  }
}
