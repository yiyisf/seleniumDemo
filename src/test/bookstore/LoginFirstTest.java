import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/3/24.
 * 登录
 * 搜索
 * 点击banner
 */


public class LoginFirstTest {


    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void test() throws InterruptedException {
        //在浏览器输入地址


        driver.get("https://fxm5547.baobaobooks.com/");
        System.out.printf(driver.getTitle());
        if (driver.getTitle().equals("小明fxm5547")) {
            System.out.printf("\n进入网站成功\n");
        } else {
            System.out.printf("\n进入网站失败\n");
        }


////        获取用户名和密码输入框
//        By user_name = By.id("username");
//        WebElement userName_webElement = driver.findElement(user_name);
//        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(userName_webElement));
//        userName_webElement.clear();
//        userName_webElement.sendKeys("13428750583");
//        Reporter.log("输入用户名");
//
//        By pass_word = By.id("password");
//        WebElement passWord_webElement = driver.findElement(pass_word);
//        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(passWord_webElement));
//        passWord_webElement.clear();
//        passWord_webElement.sendKeys("a123456");
//        Reporter.log("输入密码");
//
//
//
//        //获取登录按钮
//        By logins = By.className("login-btn");
//        WebElement logins_webElement = driver.findElement(logins);
//        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(logins_webElement));
//        logins_webElement.click();

//        点击我的
        NavinationBar navinationBar = new NavinationBar(driver);
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(navinationBar.my_webElement));
        navinationBar.clickButton1();

        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(navinationBar.title_element));
        navinationBar.clickButton2();


//        By my = By.xpath("//*[@class='icon icon-footer4']");
//        WebElement my_element = driver.findElement(my);
//        my_element.click();
//        Reporter.log("Click我的button", true);
//        Thread.sleep(3000);

//        进入登录提示页面//

//        By title = By.xpath("//*[@class='btn']");
//        WebElement title_element = driver.findElement(title);
//        Reporter.log("Find注册或登录后即可继续操作button", true);
//        Thread.sleep(3000);
//        Reporter.log("Click注册或登录后即可继续操作button", true);
//        title_element.click();
//        进入登录页面
        LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.logins_webElement));
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.userName_webElement));
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.passWord_webElement));
        loginFirstPage.business("13428750583", "a123456");
//        loginFirstPage.inputUserName("13428750583");
//        loginFirstPage.inputPassword("a123456");
        loginFirstPage.loginButton();
        System.out.printf(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "孩宝小镇 - 登录");
        Thread.sleep(3000);


        out.println("\npassed!");

//        点击搜索框
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.search_webElement));
        loginFirstPage.searchClick();
        Reporter.log("点击搜索框");


//      进入搜索页面

        By Expect = By.xpath("//*[@class='title']");
        WebElement Expect_title_webElement = driver.findElement(Expect);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String Expect_title = wait.until(ExpectedConditions.visibilityOf(Expect_title_webElement)).getText();
        System.out.printf(Expect_title + "\n");

//      判断页面是否存在预期元素：热门搜索
        String Actual_title = "热门搜索";
        System.out.printf(Actual_title);
        Assert.assertEquals(Expect_title, Actual_title);

//      输入搜索内容
        String book_name_keyword = null;
        SearchPage searchPage = new SearchPage(driver);
        book_name_keyword = "鹅妈妈";
        searchPage.inputSearchContent(book_name_keyword);
        searchPage.SearchButton();
        System.out.printf("进入搜索结果页面\n");

        Thread.sleep(3000);
//      找到搜索结果中元素对应的文本
        By Expect_book = By.xpath("//*[@class='desc']");
        WebElement Expect_book_name_webElement = driver.findElement(Expect_book);
        WebDriverWait waits = new WebDriverWait(driver, 600);
        String Expect_book_name = wait.until(ExpectedConditions.visibilityOf(Expect_book_name_webElement)).getText();
        System.out.printf(Expect_book_name + "\n");

//      判断搜索结果中是否包含搜索内容：鹅妈妈
        Assert.assertTrue(Expect_book_name.contains(book_name_keyword), "测试失败");
        System.out.printf("搜索passed\n");

//      进入首页
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(navinationBar.Firstpage_webElement));
        navinationBar.clickButton3();
        System.out.printf("进入首页\n");


//        点击banner
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.banner_webElement));
        System.out.printf("点击banner\n");
        loginFirstPage.bannerClick();


//        结果页面title比较
        BannerDetailPage bannerDetailPage = new BannerDetailPage(driver);

        WebDriverWait wait1 = new WebDriverWait(driver, 60);
        wait1.until(ExpectedConditions.titleContains("书单详情"));
//        String Actual_title ="书单详情";
//        String Expect_title = bannerDetailPage.getpageTitle();
//        System.out.printf(Expect_title);
//        Assert.assertTrue(("Expect_title:" + Expect_title).equals("Actual_title：" + Actual_title));
        System.out.printf("进入banner详情页");
        Thread.sleep(3000);


    }


    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}
