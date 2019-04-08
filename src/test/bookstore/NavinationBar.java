import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Created by liuzhe on 2019/3/26.
 */

public class NavinationBar {

    //    查找页面元素-用户名、密码、登录按钮
    @FindBy(xpath = "//*[@class='icon icon-footer4']")
    WebElement my_webElement;

    @FindBy(xpath = "//*[@class='icon icon-footer3']")
    WebElement cart_webElement;

    @FindBy(xpath = "//*[@class='icon icon-footer2']")
    WebElement category_webElement;

    @FindBy(xpath = "//*[@class='icon icon-footer1']")
    WebElement Firstpage_webElement;

    @FindBy(xpath = "//*[@class='btn']")
    WebElement title_element;


    //  初始化PO
    public NavinationBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //    参数化

    //   点击登录按钮
    public void clickButton1() {
        my_webElement.click();
        Reporter.log("点击登录button", true);

    }

    //      注册或登录后即可继续操作按钮
    public void clickButton2() {
        title_element.click();
        Reporter.log("注册或登录后即可继续操作button", true);
    }

    //   点击首页按钮
    public void clickButton3() {
        Firstpage_webElement.click();
        Reporter.log("点击首页button", true);

    }

    //   点击分类按钮
    public void clickButton4() {
        category_webElement.click();
        Reporter.log("点击分类button", true);

    }

    //   点击购物车按钮
    public void clickButton5() {
        cart_webElement.click();
        Reporter.log("点击购物车button", true);

    }

    //   点击我的按钮
    public void clickButton6() {
        my_webElement.click();
        Reporter.log("点击我的button", true);

    }


}