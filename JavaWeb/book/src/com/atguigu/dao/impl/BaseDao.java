package com.atguigu.dao.impl;
import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *@ClassName BaseDao
 *@Description  TODO
 *@Author HuangQingbin
 *@Date 2021/7/22 19:02
 *@Version 1.0
 */
public abstract class BaseDao{
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用来执行：Insert/Update/Delete语句
     * 如果返回-1,说明执行失败 返回其他表示影响的行数
     */
    public int update(String sql,Object...args){
        Connection connection = JdbcUtils.getConnection();
        try {
           return  queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回对象类型
     * @param sql   执行的sql语句
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            BeanHandler<T> handler = new BeanHandler<>(type);
            T query = queryRunner.query(conn, sql, handler, args);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }

    /**
     *
     * @param type  返回对象类型
     * @param sql   执行sql语句
     * @param args  sql对应的参数值
     * @param <T>   返回的类型的泛型
     * @return
     */

    public <T> List<T> queryForOne2(Class<T> type,String sql,Object...args){

        Connection conn = JdbcUtils.getConnection();


//        try {
//            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUtils.close(conn);
//        }
        List<T> query = null;
        try {
            BeanListHandler<T> listHandler = new BeanListHandler<>(type);
            query = queryRunner.query(conn, sql, listHandler, args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     *
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object...args){

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}

