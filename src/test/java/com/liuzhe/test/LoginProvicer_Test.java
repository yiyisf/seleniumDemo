package com.liuzhe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuzhe on 2019/4/5.
 */


public class LoginProvicer_Test {

    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

        @DataProvider
        public Iterator<Object[]> getData(){
            String path  = this.getClass().getResource("data.csv").getPath();
            System.out.println(path);
            return readDataFromCSV(path);

        }

        @Test(dataProvider="getData")
        public void testProcess1(String username,String password) throws InterruptedException {

            driver.get("https://fxm5547.baobaobooks.com/");
            System.out.printf(driver.getTitle());
            if (driver.getTitle().equals("小明fxm5547")) {
                System.out.printf("\n进入网站成功\n");
            } else {
                System.out.printf("\n进入网站失败\n");
            }



//        点击我的
            NavinationBar navinationBar = new NavinationBar(driver);
            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(navinationBar.my_webElement));
            navinationBar.clickButton1();

            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(navinationBar.title_element));
            navinationBar.clickButton2();



//        进入登录页面
            LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.logins_webElement));
            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.userName_webElement));
            new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.passWord_webElement));
            loginFirstPage.business(username, password);

            loginFirstPage.loginButton();
            System.out.printf(driver.getTitle());
            Assert.assertEquals(driver.getTitle(), "孩宝小镇 - 登录");
            Thread.sleep(3000);


            System.out.println("\n 本次登录用户名和密码分别为：");
            System.out.println(username);
            System.out.println(password);
        }

//      csv中读取文件
        public Iterator<Object[]> readDataFromCSV(String path){
            List<Object[]> list = new ArrayList<Object[]>();
            try {
                FileReader is = new FileReader(new File(path));
                BufferedReader br = new BufferedReader(is);
                while(br.ready()){
                    list.add(br.readLine().split(","));
                }
                return list.iterator();
            }catch(Exception ex){
                throw new SkipException(ex.getMessage());
            }
        }







    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}
