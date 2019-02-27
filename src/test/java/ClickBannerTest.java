import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/26.
 */

public class ClickBannerTest {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test() throws InterruptedException {
        //在浏览器输入地址
        driver.get("https://testerhome.com/");


        //通过Xpath方式找到大会图片并且点击
        By imagename = By.xpath("//*[@class=\"content hidden-mobile\"]/a/img");
        WebElement image_element = driver.findElement(imagename);
        image_element.click();

        //硬等待-线程等待
        Thread.sleep(5000);





        out.println("passed!");
    }


    @AfterMethod
    private void teardown()
    {
        driver.quit();
    }

}

