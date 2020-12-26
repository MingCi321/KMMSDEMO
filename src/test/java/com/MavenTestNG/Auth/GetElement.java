package com.MavenTestNG.Auth;

import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.lang.Thread;

public class GetElement {

    //by id
    @Test
    public void ById() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");//必须放在最前面
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        driver.findElement(By.id("kw")).sendKeys("39392");
        driver.close();
    }

    //by name
    @Test
    public void ByName() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        driver.findElement(By.name("wd")).sendKeys("问世间情为何物");
        driver.findElement(By.id("su")).click();//单机查找

        Thread.sleep(2000);
        driver.quit();
    }

    //by Xpath
    @Test
    public void ByXpath() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        driver.findElement(By.name("wd")).sendKeys("问世间情为何物");
        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();//单机查找

        Thread.sleep(2000);
        driver.quit();
    }

    //by tag
    @Test
    public void ByTag() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        System.out.print(driver.findElement(By.tagName("span")).getText());
        System.out.print(driver.findElements(By.tagName("span")).toArray()[2]);
        driver.quit();
    }
    //by-cssSelector
    @Test
    public void ByCssSelector() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        System.out.print(driver.findElement(By.cssSelector("#s-top-left > a:nth-child(6)")).getText());
    }

    //by_class
    @Test
    public void ByClass() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        System.out.print(driver.findElement(By.className("hot-refresh-text")).getText());
        driver.quit();
    }

    //by_link_text
    @Test
    public void ByLinkText() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.linkText("视频")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }
    //by_partial_link_text
    @Test
    public void ByPartialLinkText() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com");
        driver.findElement(By.partialLinkText("频")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }

}
