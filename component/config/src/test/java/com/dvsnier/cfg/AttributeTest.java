package com.dvsnier.cfg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AttributeTest
 * Created by dovsnier on 2020/8/4.
 */
public class AttributeTest {

    protected Attribute attribute_1;
    protected Attribute attribute_2;

    @Before
    public void setUp() throws Exception {
//        Debug.i("开始进行单元测试...");
        attribute_1 = new Attribute.Builder("cfg")
                .setBuildType("debug")
                .setVersionName("0.0.1")
                .setFirstTime(String.valueOf(System.currentTimeMillis()))
                .setRecentlyTime(String.valueOf(System.currentTimeMillis()))
                .create();
        attribute_2 = new Attribute.Builder("dvs")
                .setBuildType("release")
                .setVersionName("0.0.2")
                .setFirstTime(String.valueOf(System.currentTimeMillis()))
                .setRecentlyTime(String.valueOf(System.currentTimeMillis()))
                .create();
    }

    @After
    public void tearDown() throws Exception {
        //        Debug.i("单元测试执行完成...");
    }

    @Test
    public void getVersionName() {
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_1",
                attribute_1.getKeyOfVersionName(), attribute_1.getValueOfVersionName()));
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_2",
                attribute_2.getKeyOfVersionName(), attribute_2.getValueOfVersionName()));
    }

    @Test
    public void getBuildType() {
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_1",
                attribute_1.getKeyOfBuildType(), attribute_1.getValueOfBuildType()));
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_2",
                attribute_2.getKeyOfBuildType(), attribute_2.getValueOfBuildType()));
    }

    @Test
    public void getFirstTime() {
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_1",
                attribute_1.getKeyOfFirstTime(), attribute_1.getValueOfFirstTime()));
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_2",
                attribute_2.getKeyOfFirstTime(), attribute_2.getValueOfFirstTime()));
    }

    @Test
    public void getRecentlyTime() {
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_1",
                attribute_1.getKeyOfRecentlyTime(), attribute_1.getValueOfRecentlyTime()));
        System.out.println(String.format("%s, key: %s , value: %s", "attribute_2",
                attribute_2.getKeyOfRecentlyTime(), attribute_2.getValueOfRecentlyTime()));
    }
}