package com.MavenTestNG.Auth;
import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ActionChainsDemo {

    public WebDriver driver;
    @BeforeMethod
    public void BeforeMethod() {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void AfterMethod() throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }

    //ActionChains,在元素上鼠标右击和双击
    @Test
    public void func1() throws Exception{
       driver.get("http://www.baidu.com/");
       WebElement element=driver.findElement(By.id("su"));
       Actions action=new Actions(driver);
        action.contextClick(element);//右击
        action.doubleClick(element);//双击
        action.perform();
    }
    //鼠标移动到某个元素上
    @Test
    public void func2() throws Exception{
        driver.get("https://www.baidu.com/");
        WebElement element=driver.findElement(By.name("tj_briicon"));
        Actions action=new Actions(driver);
        action.moveToElement(element).perform();
    }

    //拖动元素
    @Test
    public void func3() throws Exception{
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement elementdrap=driver.findElement(By.xpath("/html/body/div[1]"));
        Actions action=new Actions(driver);
        //执行拖动到x500,y500的位置
        action.dragAndDropBy(elementdrap,100,500).perform();
    }

    //把元素拖动到另一个元素上
    @Test
    public void testClickAndHold() throws InterruptedException
    {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement oneElement=driver.findElement(By.id("drag"));
        WebElement otherElement=driver.findElement(By.xpath("/html/body/h1"));
        Actions action=new Actions(driver);
        action.clickAndHold(oneElement).moveToElement(otherElement).release(otherElement).perform();
        Thread.sleep(3000);
    }
    //下拉框多选
    @Test
    public void testDropDown() throws InterruptedException{
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Actions actions=new Actions(driver);
        WebElement select=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> options=select.findElements(By.tagName("option"));
        Action multipleSelectAction=actions.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).build();
        multipleSelectAction.perform();
    }
    //Robot类操作1,操作保存网页
    @Test
    public void test01() throws InterruptedException,AWTException{
        Thread.sleep(3000);
        Robot robot=new Robot();
        //按ctrl键

        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(5000);
        //按住s键
        robot.keyPress(KeyEvent.VK_S);
        //得到s的ASCII值
        int keyS=(int)new Character('S');
        //松开s键
        robot.keyRelease(keyS);
        //松开Ctrl键
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    //Robot类操作2，上传文件
    @Test
    public void test02() throws Exception{
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\企鹅.jpg");
    }
}
