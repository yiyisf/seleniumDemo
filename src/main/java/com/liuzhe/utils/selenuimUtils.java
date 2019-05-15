package com.liuzhe.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.Set;

/**
 * Created by liuzhe on 2019/4/8.
 */
public class selenuimUtils {
    public static void switchWindouw(WebDriver driver, long time, Set<String> handles){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.numberOfWindowsToBe(handles.size()+1));

        for (String handle:driver.getWindowHandles()){
//      如果handles（所有窗口句柄）不包含handle（新窗口句柄），切换到新窗口
            if(!handles.contains(handle)){
                driver.switchTo().window(handle);
                Reporter.log("切换到新窗口"+handle,true);
            }
        }

    }




}
