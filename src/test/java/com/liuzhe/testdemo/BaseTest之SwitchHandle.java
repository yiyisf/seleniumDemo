package com.liuzhe.testdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Created by liuzhe on 2019/2/24.
 * 基本定
 */
public class BaseTest之SwitchHandle {

    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test() {
        //打开浏览器
        driver.get("https://sz.lianjia.com/");
        //放大窗口
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //进入handle1
        String handle1 = driver.getWindowHandle();

////      定位第一个元素
//        WebElement ershoufang = driver.findElement(By.cssSelector(".home-nav")).findElements(By.tagName("a")).get(0);
////      滚动到这个元素
//        js.executeScript("arguments[0].scrollIntoView(true);", ershoufang);
//        System.out.println("ershoufang is clicable ?" + ershoufang.getText());
////      点击元素
//        ershoufang.click();


        for (WebElement e : driver.findElements(By.cssSelector(".home-nav a"))) {

            if (e.findElement(By.tagName("b")).getText().equals("找二手房")) {
                js.executeScript("arguments[0].scrollIntoView(true);", e);
                e.click();
                break;
            }
        }

        //找出与handle1不一样的handle，切换
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(handle1)) {
                driver.switchTo().window(handle1);
                System.out.println("passed!");


            }

        }



        out.println("passed!");
    }


    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}
