import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import sun.jvm.hotspot.runtime.Thread;



/**
 * Created by liuzhe on 2019/2/21.
 */

public class LoginPage {

    //定位用户名元素、密码元素、登录按钮元素
    @FindBy(name = "user[login]")
    WebElement UserName;

    @FindBy(name = "user[password]")
    WebElement UserPassword;

    @FindBy(partialLinkText = "登录")
    WebElement loginButton;


    //  初始化PO
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //  输入用户名
    public void InputUserName(String username) {
        UserName.clear();
        UserName.sendKeys(username);
        Reporter.log("输入用户名", true);
    }


    //  输入密码
    public void InputPassWord(String password) {
        UserPassword.clear();
        UserPassword.sendKeys(password);
        Reporter.log("输入密码", true);
    }

//  点击登录按钮

    public void ClickButton() {
        loginButton.click();
        Reporter.log("点击登录", true);
    }
//    封装

    public void bussinessLogin(String username,String password){
        InputUserName(username);
        InputPassWord(password);

    }
}


