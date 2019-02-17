import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.*;

/**
 * Created by liuzhe on 2019/2/17.
 */
public class DemoTest {

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

        //输入用户名、密码，登录
//        By username = By.id("username");
//        WebElement username_element = driver.findElement(username);
//        username_element.click();
//        username_element.sendKeys("13428750583");

        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("13428750583");

        //thread.sleep(5000);

        By password = By.id("password");
        WebElement password_element = driver.findElement(password);
        password_element.click();
        password_element.sendKeys("a123456");
        //thread.sleep(5000);

        By login = By.className("login-btn");
        WebElement login_element = driver.findElement(login);
        login_element.click();








        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
