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
 * alert
 */
public class BaseTest之SwitchAlert {

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

////      获取弹窗文本
//        driver.switchTo().alert().getText();
////      点击确定
//        driver.switchTo().alert().accept();
////      点击
//        driver.switchTo().alert().dismiss();
////      在弹窗中输入内容
//        driver.switchTo().alert().sendKeys("12348750583");
//
//






        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
