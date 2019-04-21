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
 * 基本定位方法-PartialLinktext定位
 */
public class BaseTest之Linktext定位 {

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

        //通过Partiallinktext定位元素
        driver.findElement(By.linkText("登")).click();
        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
