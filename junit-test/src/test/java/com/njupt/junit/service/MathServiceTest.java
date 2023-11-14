package com.njupt.junit.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试类
 * @author 76308
 * @version 1.0.0
 * @since 1.0.0
 */
public class MathServiceTest { //名字规范：要测试的类名+Test
    // 一般是一个业务方法对应一个测试方式
    // 测试方法的规范：pubic void testXxxx(){}
    // 测试方法的方法名：以test开始。
    @Test
    public void testSum(){
//        实际值：被测试业务方法的真实结果
//        期望值：期望的结果
        MathService mathService = new MathService();
        // sum 是实际值
        int sum = mathService.sum(1, 2);
        int expectedValue = 3;
        // 加断言进行测试
        Assert.assertEquals(expectedValue,sum);
    }
}
