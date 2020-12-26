package com.MavenTestNG.Auth;
//import  org.testng.annotations.Test;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

public class SeleniumAbstract {
    @BeforeSuite
    public void beforeSuite() {
        System.out.print("BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.print("BeforeTest");
    }

    @AfterClass
    public void afterClass() {
        System.out.print("AfterClass");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.print("BeforeClass");
    }


    @AfterTest
    public void afterTest() {
        System.out.print("AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.print("AfterSuite");
    }

    @Test
    public void Test1()
    {
        System.out.print("我是被你囚禁的鸟");
    }
    @Test
    public void Test2()
    {
        System.out.print("已经忘了天有多高");
    }
}
