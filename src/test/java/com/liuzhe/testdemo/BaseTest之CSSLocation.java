package com.liuzhe.testdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;
import static org.openqa.selenium.By.cssSelector;

/**
 * Created by liuzhe on 2019/2/17.
 * 基本定位方法
 */
public class BaseTest之CSSLocation {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test(){
        //在浏览器输入地址
        driver.get("https://account.baobaobooks.com/");


        //通过css进行定位
        //driver.findElement(cssSelector(".login-input username")).sendKeys("13428750583");

        driver.findElement(cssSelector("#username")).sendKeys("13428750583");

        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
