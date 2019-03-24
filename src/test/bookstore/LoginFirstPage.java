import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Created by liuzhe on 2019/3/24.
 */
public class LoginFirstPage {
//    查找页面元素-用户名、密码、登录按钮
    @FindBy(id = "username")
    WebElement userName_webElement;
    @FindBy(id = "password")
    WebElement passWord_webElement;
    @FindBy(className = "login-btn")
    WebElement logins_webElement;

    //  初始化PO
    public LoginFirstPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    //    参数化
    //  输入用户名、密码
    public void inputUserName(String username) {
        userName_webElement.clear();
        userName_webElement.sendKeys(username);
        Reporter.log("输入用户名", true);
    }
    public void inputPassword(String password) {
        passWord_webElement.clear();
        passWord_webElement.sendKeys(password);
        Reporter.log("输入密码", true);
    }

//   登录
    public void loginButton() {
        logins_webElement.click();
        Reporter.log("点击登录按钮", true);
    }


    public void business(String username,String password) {
        inputUserName(username);
        inputPassword(password);
        Reporter.log("输入用户名，密码", true);


    }




}
