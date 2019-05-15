package com.liuzhe.test;

import com.liuzhe.utils.fileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by liuzhe on 2019/4/5.
 */



public class Banner_Test {


    WebDriver driver = null;


    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();


    }

//    @Test
//    private void test() throws InterruptedException {
//        //在浏览器输入地址
//
//
//        driver.get("https://fxm5547.baobaobooks.com/");
//        System.out.printf(driver.getTitle());
//        if (driver.getTitle().equals("小明fxm5547")) {
//            System.out.printf("\n进入网站成功\n");
//        } else {
//            System.out.printf("\n进入网站失败\n");
//        }
//
//
//
//        LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
////      点击banner
//        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.banner_webElement));
//        System.out.printf("点击banner\n");
//        loginFirstPage.bannerClick();
//
//
////        结果页面title比较
//        BannerDetailPage bannerDetailPage = new BannerDetailPage(driver);
//        bannerDetailPage.waitTitleContent(3000,"书单详情");
//        System.out.printf("passed\n");
//
//    }
    @Test
    private void clickBannerTest() throws Exception{
        String url = fileUtils.readYmlFile(fileUtils.getPath("/config.yaml"),"url");
        driver.get(url);
        Thread.sleep(5000);
//        HomePage homePage = new HomePage(driver);
//        EventPage eventPage = homePage.clickBannerAndReturnPage();
//
//        String expectTitle = "大会";
//        eventPage.waitTitleContains(5,expectTitle);
        String expectTitle = fileUtils.readYmlFile(fileUtils.getPath("/clickBanner.yaml"),"expectTitle");
        new LoginFirstPage(driver).bannerClick();

        System.out.printf(driver.getTitle());
        new BannerDetailPage(driver).waitTitleContent(3000,expectTitle);
    }

//    public static String getProperty(String property)throws Exception{
//        String configPath = fileUtils.getPath("/config.yml");
//        String dataPath = fileUtils.getPath("/notSignIn.yml");
//        Map configMap = fileUtils.readYmlFile(configPath);
//        Map dataMap = fileUtils.readYmlFile(dataPath);
//        Map crossMap = new HashMap();
//        crossMap.putAll(configMap);
//        crossMap.putAll(dataMap);
//
//        return (String) crossMap.get(property);
//    }
//
//    public static void main(String[] args)throws Exception{
//        System.err.println(getProperty( "url"));
//        System.err.println(getProperty( "community"));
//    }


    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}

