package com.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Author tom
 * @Date 2018/3/21 16:09
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class PagingInterceptor implements Interceptor {
  private int limit=0;

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
    MetaObject metaStatementHandler= SystemMetaObject.forObject(statementHandler);
    //分离代理对象链(由于目标可能被多个拦截器拦截,从而形成多次代理,通过循环可以分离原始目标类)
    while(metaStatementHandler.hasGetter("h")){
      Object object=metaStatementHandler.getValue("h");
      metaStatementHandler=SystemMetaObject.forObject(object);
    }
    // BoundSql对象是处理sql语句的
    String sql=(String)metaStatementHandler.getValue("delegate.boundSql.sql");
    if(sql!=null&&sql.toLowerCase().trim().indexOf("select")==0&&!sql.contains("$_$limit_$table_")){
      sql="select * from(" + sql + ")$_$limit_$table_ limit "+this.limit;
      metaStatementHandler.setValue("delegate.boundSql.sql",sql);
    }
    return invocation.proceed();// 实际上是调用原来的prepared方法,只是在此之前我们修改了sql
  }

  @Override
  public Object plugin(Object o) {
    return Plugin.wrap(o,this);// 用plugin的wrap 方法生成代理对象
  }

  @Override
  public void setProperties(Properties properties) {
      String limitStr=properties.getProperty("page.limit").toString();
      this.limit=Integer.parseInt(limitStr);
  }
}
