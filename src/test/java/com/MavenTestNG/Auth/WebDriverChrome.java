package com.MavenTestNG.Auth;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import java.lang.Thread;


public class WebDriverChrome {
    //selenium启动火狐浏览器
    @Test
    public void OpenFF() {
        //注意这里既可以用绝对路径，也可以用相对路径
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
    }

    //selenium启动谷歌浏览器
    @Test
    public void OpenChrome() {
        //同样这里既可以用相对路径，有可用绝对路径
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }

    //启动IE浏览器
    @Test
    public void OpenIEBrowser() {
        System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
    }

    //一定要写throws InterruptedException
    //navigate().forward()/back();
    @Test
    public void OpenChrome2() throws  InterruptedException{
        System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(3000);
        driver.navigate().back();//后退
        Thread.sleep(2000);
        driver.navigate().forward();//前进
        driver.close();
    }

    //navigate.refresh()，刷新方法
    @Test
    public void OpenChrome3() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }
    //driver.manage().window().maximize(),最大化窗口方法
    //driver.manage().window().setSize(new Dimension(x,y)) 按照x,y的大小设置浏览器窗口大小
    //driver.quit() 关闭整个浏览器，close()，只关闭当前标签页的窗体
    @Test
    public void OpenChrome4() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        Dimension dimension=new Dimension(200,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(200,400));
        Thread.sleep(2000);
        driver.quit();
    }
    //driver.getCurrentUrl()//获取当前地址url
    //driver.getTitle()//获取当前title
    @Test
    public void OpenChrome5() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com/");
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());
        System.out.print(driver.getTitle());
        driver.quit();
    }
}
