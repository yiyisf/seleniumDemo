package com.liuzhe.testdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.
 * alert
 */
public class BaseTest之SwitchFrame {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test(){
        //在浏览器输入地址
        driver.get("https://weibo.com/");

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"other_login_list W_fl\"]/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class=\"other_login_list W_fl\"]/iframe")));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"J_Login\"]/div"))).click();

//      退出iframe
        driver.switchTo().defaultContent();


        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
