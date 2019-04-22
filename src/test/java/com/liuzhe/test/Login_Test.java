package com.liuzhe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.System.out;

/**
 * Created by liuzhe on 2019/4/5.
 */


public class Login_Test {

    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();
//               //启动chrome浏览器
//        try {
//            ChromeDriverService service = new ChromeDriverService.Builder()
//                    .usingDriverExecutable(new File("/tmp/chromedriver"))
//                    .usingAnyFreePort()
//                    .build();
//            service.start();
//            driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("init chrome driver error;");
//            driver = new ChromeDriver();
//
//        }


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

    }

    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}
