package com.liuzhe.test;

import com.liuzhe.utils.selenuimUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

/**
 * Created by liuzhe on 2019/4/8.
 */
public class ManageBookstoreTest {

    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        //启动chrome浏览器
        try {
            ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/tmp/chromedriver"))
                .usingAnyFreePort()
                .build();
            service.start();
            driver = new ChromeDriver(service);
        } catch (Exception e) {
            driver = new ChromeDriver();
        }

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

//        //点击我的按钮
//        MyPage myPage = new MyPage(driver);
//        myPage.clickButton6();
//        Thread.sleep(3000);

        //点击我的
        NavinationBar navinationBar = new NavinationBar(driver);
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(navinationBar.my_webElement));
        navinationBar.clickButton1();

        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(navinationBar.title_element));
        navinationBar.clickButton2();

        //进入登录页面
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

        //点击我的按钮
        MyPage myPage = new MyPage(driver);
        myPage.clickButton6();
        Thread.sleep(3000);

        //获取原窗口（主窗口句柄）
        String oldHandle = driver.getWindowHandle();
        //获取所有窗口句柄
        Set<String> handles = driver.getWindowHandles();

        //打印日志
        Reporter.log("原窗口是"+oldHandle,true);
        Reporter.log("handles是"+handles,true);



        //点击管理童书馆
        driver.findElement(By.xpath("//*[@class='item has-icon'][2]")).click();
        selenuimUtils.switchWindouw(driver,2000,handles);


//        WebDriverWait wait = new WebDriverWait(driver, 3000);
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//        for (String handle:driver.getWindowHandles()){
////      如果新窗口不等于旧窗口，切换到新窗口
//            if(!handle.equalsIgnoreCase(oldHandle)){
//                driver.switchTo().window(handle);
//                Reporter.log("切换到新窗口"+handle,true);
//            }
//        }


        Thread.sleep(3000);

////      关掉弹窗
//        Alert a = driver.switchTo().alert();
//        a.getText();
//        System.out.printf(a.getText());
//        //获取提示框的文本内容
//        a.accept();
//        //点击提示框的确定按钮
//        a.dismiss();
//        //点击提示框的取消按钮




    }

    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}

