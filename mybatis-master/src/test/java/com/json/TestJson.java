package com.json;

import com.diamond.pojo.Person;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;


import java.util.Map;

/**
 * @Author tom
 * @Date 2018/3/26 14:44
 */

public class TestJson {
  /*public static void main(String[] args) {
  ObjectM
  }*/
  public  static Map<Object,Object> jsonToMap(Object jsonObj){
    JSONObject jsonObject=JSONObject.fromObject(jsonObj);
    Map<Object,Object> map=(Map)jsonObj;
    return map;
  }
  /*
  * json String 转化为对象
  * */
  public static <T> T jsonToBean(Object jsonObj,Class<T> type){
    JSONObject jsonObject=JSONObject.fromObject(jsonObj);
    T obj=(T)JSONObject.toBean(jsonObject,type);
    return  obj;
  }

  public static void main(String[] args) {
    String jsonStr = "{\"status\":\"0\",\"data\":{\"name\":\"tom\",\"age\":18}}";
  //  Object object=;
    Map<Object, Object> result = jsonToMap(jsonStr);
    System.out.println(result.get("status"));
    System.out.println(result.get("data"));

    /*Map<Object, Object> data = jsonToMap(result.get("data"));
    System.out.println(data.get("name"));
    System.out.println(data.get("age"));
    // ================================

    Long beginTime = System.currentTimeMillis();
    String personStr = "{\"id\":12,\"name\":\"mary\"}";
    Person person = jsonToBean(personStr, Person.class);
    System.out.println(person);

    System.out.println("耗时："  +( System.currentTimeMillis() - beginTime));*/


  }
}
