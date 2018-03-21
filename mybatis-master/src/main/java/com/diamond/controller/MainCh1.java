package com.diamond.controller;

import com.diamond.mapper.UserMapper;
import com.diamond.pojo.User;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author tom
 * @Date 2018/3/20 15:54
 */
@Log4j2
public class MainCh1 {
  public static void main(String[] args) {
    SqlSessionFactory sqlSessionFactory=null;
      try{
        sqlSessionFactory=new SqlSessionFactoryBuilder().
            build(Resources.getResourceAsReader("configuration-chapter1.xml"));
       }catch(IOException e){
    log.info("创建sqlSessionFactory失败",e);
    return;
      }
    // 定义sqlSession
    SqlSession sqlSession=null;
     try{
         /*
            sqlsession 创建sqlsession

         * */
         sqlSession=sqlSessionFactory.openSession();
         /*
         * 获取mapper
         * */
       UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
       /*
       * 执行mapper方法
       * */
       User user=userMapper.findUserById(0);
       System.out.println(user.getCname());

      }finally {
       if(sqlSession!=null){
         sqlSession.close();
       }
      }

      /*
       会出现空指针异常
      * */
  }
}
