import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Created by liuzhe on 2019/4/1.
 */
public class SearchPage {

    //    查找页面元素-搜索框
        //    查找页面元素-搜索按钮_
        //    搜索关键字
        @FindBy(xpath = "//*[@class='search']")
        WebElement search_webElement;
        public void inputSearchContent(String content) {
            search_webElement.clear();
            search_webElement.sendKeys(content);
            Reporter.log("\n输入搜索内容", true);
        }





        @FindBy(xpath = "//*[@class='search-btn']")
        WebElement searchButton_webElement;
    //  初始化PO
        WebDriver driver;
        public SearchPage(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }
        public SearchResultPage SearchButton(String content) {
            inputSearchContent(content);
            searchButton_webElement.click();
            Reporter.log("\n点击搜索按钮", true);
            return new SearchResultPage(driver);
        }

//    public SearchResultPage gotoSearchResult(String value){
//        inputSearchContent(value);
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.ENTER).perform();
//        return new SearchResultPage(driver);
//    }

        @FindBy(xpath = "//*[@class='item-group clear']/div[1]")
        WebElement searchKeyword_webElement;
        public void searchKeyword_button() {
            search_webElement.click();
            Reporter.log("\n点击搜索关键字", true);
        }






}
