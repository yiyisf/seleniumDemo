package com.liuzhe.testdemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.
 * 基本定位方法
 */
public class BaseTest之screenshotTest {

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

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file, new File("/Users/liuzhe/Desktop/peixun/screenshot"));

        }catch (Exception ex){
            throw new SkipException(ex.getMessage());
        }


        System.out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
