import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.
 */
public class LoginTest {


    
    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test(){
        //在浏览器输入地址
        driver.get("https://testerhome.com/account/sign_in");

        //输入用户名id
        // 密码id
        // 登录按钮name

        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("779402401@qq.com");

//       //硬等待
//        try{
//        Thread.sleep(5000);
//        } catch (Exception e){
//
//        }
        //隐式等待 -10S内
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //显示等待


        By password = By.id("user_password");
        WebElement password_element = driver.findElement(password);
        password_element.click();
        password_element.clear();
        password_element.sendKeys("lz1988");
        //thread.sleep(5000);

        By login = By.name("commit");
        WebElement login_element = driver.findElement(login);
        login_element.click();


        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
