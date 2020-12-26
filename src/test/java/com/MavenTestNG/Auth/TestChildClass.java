package com.MavenTestNG.Auth;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;

public class TestChildClass extends SeleniumAbstract{

    @Test
    public void Test01()
    {
        System.out.print("如果离开你给我的小小城堡");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.print("AfterMethod");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.print("BeforeMethod");
    }

}
