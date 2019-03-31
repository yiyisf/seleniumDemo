import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by liuzhe on 2019/3/31.
 */
public class BannerDetailPage {

    WebDriver driver;

    //  初始化PO
    public BannerDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getpageTitle() {
        return driver.getTitle();

    }
}
