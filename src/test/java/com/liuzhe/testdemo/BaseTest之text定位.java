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
 * 基本定位方法-text定位
 */
public class BaseTest之text定位 {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test(){
        //在浏览器输入地址
        driver.get("https://testerhome.com/topics");

        //通过linktext定位元素
       driver.findElement(By.linkText("登录")).click();

        //通过getText获取标签内的文本
//        String s = driver.findElement(By.linkText("登录")).getText();

        //getTagName获取标签名字
//        String s = driver.findElement(By.linkText("登录")).getTagName();

        //getAttribute获取属性值
//        String s = driver.findElement(By.linkText("登录")).getAttribute("name");

//        out.println(s);
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
