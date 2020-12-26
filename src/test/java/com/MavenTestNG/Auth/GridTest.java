package com.MavenTestNG.Auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class GridTest {

    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities类型,当前案例执行时要分配的浏览器的选择
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.31.209:4445/wd/hub"), dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(1000);
        driver.quit();

    }

    @Test
    public void testFireFox() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities类型,当前案例执行时要分配的浏览器的选择
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.31.209:4445/wd/hub"), dc);
        driver.get("https://www.baidu.com");
        Thread.sleep(1000);
        driver.quit();

    }

    @DataProvider(name = "data4")
    public Object[][] test1() {
        return new Object[][]{
                {"http://192.168.31.209:6633", "firefox"},
                {"http://192.168.31.209:8887", "chrome"}
        };
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String url, String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities;
        if (browser == "chrome") {
            desiredCapabilities = DesiredCapabilities.chrome();
        } else if (browser == "firefox") {
            desiredCapabilities = DesiredCapabilities.firefox();
        } else {
            desiredCapabilities = DesiredCapabilities.internetExplorer();
        }
        String uri = url + "/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(uri), desiredCapabilities);
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        driver.quit();
    }
//    @DataProvider(name = "data5")
//    public Object[][] test2() {
//        return new Object[][]{
//                {"http://192.168.31.209:6633", "firefox"},
//                {"http://192.168.31.209:8887", "chrome"}
//        };
//    }

//    @Test(dataProvider = "data5")
//    public void testGrid3(HashMap<String,String> map) throws MalformedURLException, InterruptedException {
//        DesiredCapabilities desiredCapabilities;
//        if (browser == "chrome") {
//            desiredCapabilities = DesiredCapabilities.chrome();
//        } else if (browser == "firefox") {
//            desiredCapabilities = DesiredCapabilities.firefox();
//        } else {
//            desiredCapabilities = DesiredCapabilities.internetExplorer();
//        }
//        String uri = url + "/wd/hub";
//        WebDriver driver = new RemoteWebDriver(new URL(uri), desiredCapabilities);
//        driver.get("http://www.baidu.com");
//        Thread.sleep(2000);
//        driver.quit();
//    }.
}

