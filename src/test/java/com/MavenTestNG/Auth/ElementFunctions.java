package com.MavenTestNG.Auth;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Action;

import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;


public class ElementFunctions {

    public WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        //创建一个DesiredCapabilities类型,当前案例执行时要分配的浏览器的选择
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个driver
        driver = new RemoteWebDriver(new URL("http://192.168.31.209:4445/wd/hub"), dc);


    }

    //click()、clear()、sendkeys(),getTitle(),getCurrenturl
    @Test
    public void func1() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.id("kw")).sendKeys("淇水汤汤");

        driver.findElement(By.id("kw")).clear();

        driver.findElement(By.id("kw")).sendKeys("淇水汤汤");

        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("su")).click();
    }

    //检查元素是否展示, isDisplayed()
    @Test
    public void func2() throws InterruptedException {
        driver.get("https://www.baidu.com");
        boolean bl = driver.findElement(By.id("su")).isDisplayed();

        Assert.assertTrue(bl);
    }

    //isSelected()
    @Test
    public void func3() throws InterruptedException {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id='radio']/input[1]"));
        element.click();
        boolean bl = element.isSelected();

        Assert.assertTrue(bl);
    }

    //isEnabled(),判断input type=button的元素是否可用
    @Test
    public void func4() {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Assert.assertFalse(driver.findElement(By.xpath("//input[@name='buttonhtml']")).isEnabled());
    }

    //截图
    @Test
    public void func5() {
        driver.get("https://www.baidu.com/");
        File fileScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fileScreenShot, new File("D:/screenShot/screenShot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //alert方法
    @Test
    public void func6() throws InterruptedException {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.xpath(".//*[@id='alert']/input")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    //confirm方法
    @Test
    public void func7() throws InterruptedException {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.xpath(".//*[@id='confirm']/input")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    //prompot方法
    @Test
    public void func8() throws InterruptedException {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.findElement(By.xpath(".//*[@id='prompt']/input")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("eaaaef"); //是chrome一个bug

        alert.accept();//模拟点击确定

        alert.dismiss();//模拟点击取消
    }

    //iframe
    @Test
    public void func9() throws InterruptedException {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.switchTo().frame("aa");
        driver.findElement(By.xpath(".//*[@id='user']")).sendKeys("我是被你囚禁的鸟");

    }

    //Select 下拉框
    @Test
    public void func10() throws InterruptedException {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = driver.findElement(By.xpath(".//*[@id='select']/select"));
        Select select = new Select(element);
        select.selectByIndex(1);

        select.selectByValue("meizu");

        select.selectByVisibleText("iphone");

    }

    //切换浏览器子窗口
    @Test
    public void func11() throws InterruptedException {
        driver.get("http://www.baidu.com/");
        System.out.println("第一标签页的handle:" + driver.getWindowHandle());

        driver.findElement(By.linkText("新闻")).click();
        System.out.println("第二标签页的handle:" + driver.getWindowHandle());

        String currentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (currentHandle.equals(handle)) {
                System.out.println(handle + "相同");
                continue;
            } else {
                try {
                    System.out.println(handle);
                    System.out.println("切换前url地址" + driver.getTitle());
                    driver.switchTo().window(handle);
                    System.out.println("切换后url地址" + driver.getTitle());
                    System.out.println("切换handle后的标签页的handle:" + driver.getWindowHandle());//handle切换成功了，但是标签页面上不切换
                    driver.navigate().refresh();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("无法切换至打开的窗口");
                }

            }
        }
//        Thread.sleep(4000);
    }

    //全局等待，隐式等待
    @Test
    public void func12() throws Exception {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");

        try {
            driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
//        ((JavascriptExecutor) driver).executeAsyncScript("window.scrollTo(0,document.body.scrollHeight)");
            //click()会自动调用将下拉滚动条
            driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
            String text = driver.findElement(By.xpath(".//div[@id='display']/div[@class='red']")).getText();

            Assert.assertEquals(text, "wait for display");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    //特定元素的，显示等待
    @Test
    public void func13() throws  Exception {
        driver.get("G:\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(3000);
        try {
            driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
            WebDriverWait wait=new WebDriverWait(driver,9);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='display']/div[@class='red']")));

            String text = driver.findElement(By.xpath(".//div[@id='display']/div[@class='red']")).getText();

            Assert.assertEquals(text, "wait for display");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    //phantomjsDriver
    @Test
    public void func14() throws Exception{
        //设置phantomjs driver路径
        System.setProperty("phantomjs.binary.path",".\\driver\\");
        //打开PhantomJs浏览器
        PhantomJSDriver driver=new PhantomJSDriver();
        driver.get("https://www.baidu.com");
        String title=driver.getTitle();
        System.out.println(title);

    }

    @AfterMethod
    public void AfterMethod()
    {
        driver.quit();
    }
}























