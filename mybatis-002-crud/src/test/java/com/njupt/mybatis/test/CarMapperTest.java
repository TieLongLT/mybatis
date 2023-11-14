package com.njupt.mybatis.test;

import com.njupt.mybatis.pojo.Car;
import com.njupt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.beans.BeanProperty;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;


public class CarMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();

        Car car = new Car(4L,"9999","凯美瑞",30.3,"1999-10-10","燃油车");

         int count = sqlSession.update("updateById",car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteById", 13);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null,"3333","比亚迪秦",30.0,"2020-11-11","新能源");
        int count = sqlSession.insert("insertCar",car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();




        // 前端传过来数据
        // 这个对象我们先使用Map集合进行数据的封装。
        Map<String,Object> map = new HashMap<>();
        map.put("carNum","1111");
        map.put("brand","比亚迪汉2");
        map.put("guidePrice",10.0);
        map.put("produceTime","2020-11-11");
        map.put("carType","电车");





        // 执行SQL语句
        // insert方法参数：
        // 第一个参数：sqlId,从CarMapper.xml文件中复制
        // 第二个参数：封装数据的对象，这个对象往SQL语句中的占位符传值。
        int count = sqlSession.insert("insertCar",map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


}
