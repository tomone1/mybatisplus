package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.diamond.pojo.Person;

import java.util.Map;

/**
 * @Author tom
 * @Date 2018/3/26 16:04
 */

public class JsonToMap {
  public static void main(String[] args) {
    String str="{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
    // 第一种方式
    Map maps= (Map) JSON.parse(str);
    System.out.println(maps.get(1));
    // 第二種方式
    maps= JSONObject.parseObject(str);
    System.out.println(maps.get(0));
    //第三種凡是
   Map maps1=JSON.parseObject(str,Map.class);
    System.out.println(maps1.get("1"));
    // 第四种方式
    maps=(Map)JSONObject.parse(str);
    System.out.println(maps.get("0"));
    // 第五钟方式
    JSONObject jsonObject=JSONObject.parseObject(str);
    //System.out.println((Map)jsonObject.get("1"));
    for (Object map : jsonObject.entrySet()){
      System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
    }
//第六种方式'
    maps=JSONObject.parseObject(str,Map.class);
    System.out.println(maps.get("1"));
    String jsonStr = "{\"status\":\"0\",\"data\":{\"name\":\"tom\",\"age\":18}}";
    maps= JSONObject.parseObject(jsonStr,Map.class);
    Person person=(Person)JSONObject.parseObject(maps.get("data").toString(),Person.class);
    System.out.println(person.getName());
  }
  // 第六种

}
