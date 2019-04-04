import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhe on 2019/4/4.
 */

public class SearchTest {


    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();

    }

    @Test
    private void searchTest() throws InterruptedException {
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
        String keyword = "鹅妈妈";
        String expectGoodsName = "有试听 廖彩杏书单 英国进口 经典版鹅妈妈童谣合集 My Very First Mother Goose Pack 点读版【超大开本平装】";


        SearchResultPage searchResultPage = searchPage.gotoSearchResult(keyword);
        Thread.sleep(3000);


        List<String> assertMsg = new ArrayList<String>();
        int i = 1;
        for(String goods_desc : searchResultPage.returnGoodsname()) {
            System.err.println("正在校验第" + i++ + "条数据");
            if(!goods_desc.contains(expectGoodsName)){
                assertMsg.add("期待的标题不包含" + expectGoodsName + "实际的标题是" + goods_desc +"\r\n");
            }else {

                System.out.printf("pass");
            }
        }

        if(!assertMsg.isEmpty()) {
            Assert.assertTrue(false, assertMsg.toString());
        }



    }


    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}

