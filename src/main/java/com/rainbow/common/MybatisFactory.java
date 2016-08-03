package com.rainbow.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by rainbow on 2016/6/19.
 * 每天进步一小点
 */
public class MybatisFactory {
    public static SqlSessionFactory sqlSessionFactory=null;
    public static SqlSession sqlSession=null;

    /**
     * 静态方法，直接可以调用
     */
    static {
        //读取配置文件
        String resource="mybatis/SqlMapConfig.xml";
        Reader reader=null;
        try{
            reader= Resources.getResourceAsReader(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
    }
    /**
     * 创建sqlSession
     */
    public static SqlSession getSqlSession(){
        sqlSession=sqlSessionFactory.openSession();
        return sqlSession;
    }
}
