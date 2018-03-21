package com.dynamic;

/**
 * @Author tom
 * @Date 2018/3/21 15:02
 */

public class ProxyTest {
  public static void main(String[] args) {
    HelloServiceProx prox =new HelloServiceProx();
    HelloService service=new HelloServiceImpl();
    // 绑定代理对象
    service=(HelloService)prox.bind(service,new Class[]{HelloService.class});
    service.sayHello("葛永涛");
  }
}
