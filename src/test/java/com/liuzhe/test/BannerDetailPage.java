package com.liuzhe.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by liuzhe on 2019/3/31.
 */
public class BannerDetailPage  extends NavinationBar{

    WebDriver driver;

    //  初始化PO
    public BannerDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitTitleContent(long time,String part_title) {
//        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.titleContains(part_title));

    }
}
