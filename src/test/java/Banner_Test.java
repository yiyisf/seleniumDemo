import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test
    private void test() throws InterruptedException {
        //在浏览器输入地址


        driver.get("https://fxm5547.baobaobooks.com/");
        System.out.printf(driver.getTitle());
        if (driver.getTitle().equals("小明fxm5547")) {
            System.out.printf("\n进入网站成功\n");
        } else {
            System.out.printf("\n进入网站失败\n");
        }



        LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
//      点击banner
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(loginFirstPage.banner_webElement));
        System.out.printf("点击banner\n");
        loginFirstPage.bannerClick();


//        结果页面title比较
        BannerDetailPage bannerDetailPage = new BannerDetailPage(driver);
        bannerDetailPage.waitTitleContent(3000,"书单详情");
        System.out.printf("passed\n");

    }


    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}

