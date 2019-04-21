package com.liuzhe.testdemo;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by liuzhe on 2019/2/26.
 */
public class SearchKeywordTest {
    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    private void test() throws Exception{
        driver.get("https://testerhome.com/");

        //通过Xpath查找元素
        By searchname = By.xpath("//*[@class=\"form-control\"]");
        WebElement search_element = driver.findElement(searchname);
        search_element.clear();
        search_element.sendKeys("selenium");
        Thread.sleep(5000);
        //点击enter键
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();




    }

    @AfterMethod
    private void teardowm(){
        driver.quit();
    }


}
