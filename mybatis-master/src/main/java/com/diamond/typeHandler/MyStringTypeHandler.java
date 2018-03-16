package com.diamond.typeHandler;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author tom
 * @Date 2018/3/15 17:15
 */
@MappedTypes({String.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
@Log4j2
public class MyStringTypeHandler implements TypeHandler<String> {
  @Override
  public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
    log.info("使用我的TypeHandler");
    preparedStatement.setString(i,s);
  }

  @Override
  public String getResult(ResultSet resultSet, String s) throws SQLException {
    log.info("使用我的TypeHandler,ResultSet 列名获取字符串");

    return resultSet.getString(s);
  }

  @Override
  public String getResult(ResultSet resultSet, int i) throws SQLException {
    log.info("使用我的TypeHandler,ResultSet 下标获取字符串");
    return resultSet.getString(i);
  }

  @Override
  public String getResult(CallableStatement callableStatement, int i) throws SQLException {
    log.info("使用我的TypeHandler,CallableStatement 下标获取字符串");
    return callableStatement.getString(i);
  }
}
