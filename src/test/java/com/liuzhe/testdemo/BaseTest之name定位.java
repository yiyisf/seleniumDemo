package com.liuzhe.testdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.
 * 基本定位方法-name定位
 */
public class BaseTest之name定位 {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test(){
        //打开浏览器地址
        driver.get("https://testerhome.com/account/sign_in");

        //通过name进行定位
        driver.findElement(By.name("user[login]")).clear();
        driver.findElement(By.name("user[login]")).sendKeys("13428750583");

        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
