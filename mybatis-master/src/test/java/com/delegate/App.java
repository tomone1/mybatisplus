package com.delegate;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author tom
 * @Date 2018/3/20 17:51
 */

public class App {
  public static void main(String[] args)throws  ClassNotFoundException ,InvocationTargetException,InstantiationException,IllegalAccessException,NoSuchMethodException{
  /*
  * 通过反射创建ReflectService 对象
  *
  * */
   // Object service=Class.forName("App").newInstance();
    Object o= Class.forName("com.delegate.App");

  /*
  * 获取服务方法
  * */
    //Method method=service.getClass().getMethod("sayHello",String.class);
    /*
    * 反射调用方法
    * */
   // method.invoke(service,"葛永涛");
  }
}
