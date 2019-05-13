package com.liuzhe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhe on 2019/4/4.
 */

public class SearchParameterTest {


    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();

    }
    @DataProvider
   public Object[][] getData(){
       Object[][] o={{"有试听 廖彩杏书单 英国进口 经典版鹅妈妈童谣合集 My Very First Mother Goose Pack 点读版【超大开本平装】"},{"小猪"}};
       return o;

   }



    @Test (dataProvider = "getData")
    private void searchTest(String s) throws InterruptedException {
        //在浏览器输入地址


        driver.get("https://fxm5547.baobaobooks.com/");
        System.out.printf(driver.getTitle());
        if (driver.getTitle().equals("小明fxm5547")) {
            System.out.printf("\n进入网站成功\n");
        } else {
            System.out.printf("\n进入网站失败\n");
        }

        LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
        loginFirstPage.searchClick();

        SearchPage searchPage = new SearchPage(driver);

        String expectGoodsName = "有试听 廖彩杏书单 英国进口 经典版鹅妈妈童谣合集 My Very First Mother Goose Pack 点读版【超大开本平装】";


        SearchResultPage searchResultPage = searchPage.gotoSearchResult(s);
        Thread.sleep(3000);


        List<String> assertMsg = new ArrayList<String>();
        int i = 1;
        for(String goods_desc : searchResultPage.returnGoodsname()) {
            System.err.println("正在校验第" + i++ + "条数据");
            if(!goods_desc.contains(expectGoodsName)){
                assertMsg.add("期待的标题不包含:" + expectGoodsName + ",实际的标题是:" + goods_desc +"\r\n");
            }else {

                System.out.printf("pass");
            }
        }

//      非空则抛异常
//        if(!assertMsg.isEmpty()) {
//        Assert.assertTrue(false, assertMsg.toString());
//        }

        /**
         * assertMsg.isEmpty()为true,则提示成功；如果是false，则抛出异常
         * @param condition
         * @param message
         */
        Assert.assertTrue(assertMsg.isEmpty(), assertMsg.toString());
//        }



    }


    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}

