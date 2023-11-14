package com.njupt.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws Exception{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder =  new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("com/mybatis-config.xml");//Resources.getResourceAsStream默认就是从类的根路径下开始查找资源。
        SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        int count = sqlSession.insert("insertCar"); // 返回值是影响数据库表当中的记录条数
        System.out.println("插入了几条记录：" + count);
        // 提交sql
        sqlSession.commit();
    }
}
