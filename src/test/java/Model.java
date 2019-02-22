import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by liuzhe on 2019/2/17.
 */
public class Model {
    WebDriver driver = null;

    @BeforeMethod
    private void setup(){
        driver = new ChromeDriver();

    }

    @Test
    private void test(){
        driver.get("https://testerhome/com/");
    }


    @AfterMethod
    private void teardown(){
        driver.quit();
    }

}
