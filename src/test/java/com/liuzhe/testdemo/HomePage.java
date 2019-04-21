package com.liuzhe.testdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


/**
 * Created by liuzhe on 2019/2/21.
 */
public class HomePage {
    @FindBy(partialLinkText = "登录")
    WebElement LinkLogin;

//    初始化po
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void clickLogin(){
        LinkLogin.click();
        if (LinkLogin == null) {
            Reporter.log("Login button is null!!!");
        }
        Reporter.log("点击登录链接",true);
    }
}
