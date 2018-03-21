package com.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author tom
 * @Date 2018/3/21 14:51
 */

public class HelloServiceProx implements InvocationHandler {

  private  Object target;
  /*
  *  绑定委托对象返回一个代理占位
  * */
  public Object bind(Object target,Class[] interfaces){
    this.target=target;
   return Proxy.newProxyInstance(target.getClass().getClassLoader(),
       target.getClass().getInterfaces(),this);

  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("#############我是JDK动态代理##############");
    Object result=null;
    //反射方法调用
    System.out.println("我准备说Hello");
    //反射执行方法
    result=method.invoke(target,args);
    //反射方法后调用
    System.out.println("我说过hello了");
    return result;
  }
}
