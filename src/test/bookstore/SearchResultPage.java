import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzhe on 2019/4/1.
 */
public class SearchResultPage extends NavinationBar {

        WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public List<WebElement> book_names;
    public List<String> SearchResultPage(){
        List<String> list = new ArrayList<String>();
        for (WebElement book_name:book_names){
            list.add(book_name.getText().trim().toLowerCase());
        }
        return list;

    }



}
