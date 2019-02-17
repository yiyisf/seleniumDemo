import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by liuzhe on 2019/2/17.
 */
@Test
public class SearchKeybord {
    WebDriver driver = null;

    @BeforeMethod
    private  void setup(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    private void test() throws Exception{
        driver.get("https://testerhome.com/");

        //By search= driver.findElement();



    }

    @AfterMethod
    private void teardowm(){
        driver.quit();
    }


}
