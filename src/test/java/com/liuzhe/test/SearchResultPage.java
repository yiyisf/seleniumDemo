package com.liuzhe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhe on 2019/4/4.
 */
public class SearchResultPage {


    WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[@class='desc']")
    public List<WebElement> goods_descs;

    public List<String> returnGoodsname(){
        List<String> list = new ArrayList<String>();
        for(WebElement goods_desc : goods_descs){
            list.add(goods_desc.getText());
            Reporter.log("\n", true);
        }
        return list;

    }



}
