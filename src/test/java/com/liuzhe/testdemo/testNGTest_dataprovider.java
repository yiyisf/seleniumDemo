package com.liuzhe.testdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by liuzhe on 2019/2/20.
 */
public class testNGTest_dataprovider {
    @DataProvider
    public Object[][] getData(){
        Object[][] o = {
                {"jim","12345"},
                {"lining","23456"},
                {"xiaomi","34567"},

        };
        return o;

    }

    @Test(dataProvider="getData")
    public void testProcess1(String username,String password){
        System.out.println(username);
        System.out.println(password);
    }




}

