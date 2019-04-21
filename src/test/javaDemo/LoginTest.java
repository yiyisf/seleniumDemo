import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/2/17.†
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
        driver.get("https://testerhome.com/");

//        //获取登录按钮
//        By logins = By.linkText("登录");
//        WebElement logins_element = driver.findElement(logins);
//        logins_element.click();

        HomePage homepage = new HomePage(driver);
        homepage.clickLogin();

        LoginPage loginpage = new LoginPage(driver);
//        loginpage.InputUserName("13428750583");
//        loginpage.InputPassWord("lz1988");
//        loginpage.ClickButton();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginpage.UserName));
        loginpage.bussinessLogin("13428750583","lz1988");
        loginpage.ClickButton();

        //输入用户名id
        // 密码id
        // 登录按钮name

        //driver.findElement(By.id("user_login")).click();
        //driver.findElement(By.id("user_login")).clear();
        //driver.findElement(By.id("user_login")).sendKeys("779402401@qq.com");

//       //硬等待
//        try{
//        Thread.sleep(5000);
//        } catch (Exception e){
//
//        }
//        //隐式等待 -10S内
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      显示等待
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        WebElement user_login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));
//        user_login.clear();
//        user_login.sendKeys("779402401@qq.com");
//
//
//        By password = By.id("user_password");
//        WebElement password_element = driver.findElement(password);
//        password_element.click();
//        password_element.clear();
//        password_element.sendKeys("lz1988");
//        //thread.sleep(5000);
//
//
//        By login = By.name("commit");
//        WebElement login_element = driver.findElement(login);
//        login_element.click();
//
//


//      判断是否登录成功-用户名
//      找到头像元素，点击头像
//      WebElement image_element = driver.findElement(By.cssSelector(".dropdown-avatar"));

//        WebElement image_element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".dropdown-avatar")));
//        image_element.click();

//      找到列表中的第一个元素的text，与预期的text进行比较
//        String expect_username="zgxlz";
//        String actual_username = driver.findElement(By.cssSelector(".dropdown-avatar ul li")).getText();
//
//        assertEquals(actual_username,expect_username,"expected" + expect_username + ",but found " + actual_username);


        out.println("passed!");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
