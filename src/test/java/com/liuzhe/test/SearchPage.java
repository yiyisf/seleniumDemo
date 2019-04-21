package com.liuzhe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Created by liuzhe on 2019/4/1.
 */
public class SearchPage {

//   @DataProvider
//   public Object[][] getData(){
//       Object[][] o={{"鹅妈妈"},{"小猪"}};
//       return o;
//
//   }

    //    查找页面元素-搜索框
    //    查找页面元素-搜索按钮

    @FindBy(xpath = "//*[@class='search']")
    WebElement search_webElement;
//    @Test (dataProvider = "getData")
    public void inputSearchContent(String content) {
        search_webElement.clear();
        search_webElement.sendKeys(content);
        Reporter.log("\n//输入搜索内容\n", true);
    }


    @FindBy(xpath = "//*[@class='search-btn']")
    WebElement searchButton_webElement;
    //  初始化PO
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //    搜索按钮
    public SearchResultPage gotoSearchResult(String content) {
        inputSearchContent(content);
        searchButton_webElement.click();
        Reporter.log("//点击搜索按钮\n", true);
        return new SearchResultPage(driver);

    }

    //    搜索按钮
    public void SearchButton() {
        searchButton_webElement.click();
        Reporter.log("//点击搜索按钮\n", true);

    }




    //    搜索关键字
    @FindBy(xpath = "//*[@class='item-group clear']/div[1]")
    WebElement searchKeyword_webElement;

    public void searchKeyword_button() {
        search_webElement.click();
        Reporter.log("//点击搜索关键字\n", true);
    }


}
