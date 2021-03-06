package com.liuzhe.testdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.
 */
//支持groups
public class testNGTestDepend {

    WebDriver driver = null;

    //@BeforeMethod
    @BeforeClass()
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();
        out.println("打开浏览器");

    }

    @Test()
    private void test1() {
        //在浏览器输入地址
        driver.get("https://account.baobaobooks.com/");
        out.println("进入登录页面");
        //Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = {"test1"} )
    private void test2() {
        //在浏览器输入地址
        driver.get("https://fxm5547.baobaobooks.com/");
        out.println("进入首页");
    }


    //@AfterMethod
    @AfterClass
    private void teardown(){
        driver.quit();
        out.println("关闭浏览器");
    }

}

