package com.liuzhe.testdemo;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.
 * 基本定位方法
 */
public class BaseTest之cookieTest {

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

        for(Cookie cookie:driver.manage().getCookies()){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());

        }

        out.println("passed!");
    }
    @Test
    private void test1(){
        //在浏览器输入地址
        driver.get("https://account.baobaobooks.com/");

        driver.manage().deleteAllCookies();

        out.println("passe1!");
    }
    @Test
    private void test2(){
        //在浏览器输入地址
        driver.get("https://account.baobaobooks.com/");

        Cookie cookie = new Cookie("name","123456","/",null);
        driver.manage().addCookie(cookie);



        out.println("passed2!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
