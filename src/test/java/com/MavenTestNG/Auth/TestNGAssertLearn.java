package com.MavenTestNG.Auth;
import org.testng.Assert;
import org.testng.asserts.*;
import  org.testng.annotations.*;

public class TestNGAssertLearn {
    /*
    assertEquals
     */
    @Test
    public void Test01(){
        //实际是“期望是1”，预期是“期望是1”
        Assert.assertEquals("期望是1","期望是1");
    }
    //断言失败
    @Test
    public void Test02(){
        //实际是“期望是1”，预期是“期望是1”
        Assert.assertEquals("实际是1","期望是1");
    }

    @Test
    public void Test03(){
        Assert.assertNotEquals("实际是1","期望是1");//message参数可以不写
    }
    //断言失败
    @Test
    public void Test04(){
        Assert.assertNotEquals("1","1","1和1不是不相等");
    }

    @Test
    public void Test05()
    {
        Assert.assertNotNull("3931");
    }
    //断言失败
    @Test
    public void Test06()
    {
         Object o=null;
        Assert.assertNotNull(o);
    }
    @Test
    public void Test07()
    {
        boolean e=3<2;
        Assert.assertFalse(e);
    }
    @Test
    public void Test08()
    {
        boolean e=3>2;
        Assert.assertFalse(e);
    }
    @Test
    public void Test09()
    {
        boolean d=3>2;
        Assert.assertTrue(d);
    }
    //断言失败
    @Test
    public void Test10()
    {
        boolean d=3<2;
        Assert.assertTrue(d);
    }


}
