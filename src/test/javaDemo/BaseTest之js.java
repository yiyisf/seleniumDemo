import javafx.scene.web.WebEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.awt.SystemColor.window;
import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.
 * 基本定位方法
 */
public class BaseTest之js {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();


    }

    @Test
    private void test(){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //在浏览器输入地址
        driver.get("https://testerhome.com/");

//      WebElement element = driver.findElement(By.className("item item5"));
        WebElement element = driver.findElement(By.xpath("//*[@class=\"item item5\"]/div/img"));
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();

        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
