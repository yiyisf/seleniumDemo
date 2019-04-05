import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuzhe on 2019/4/4.
 */

public class SearchProviderTest {


    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        //启动chrome浏览器
        driver = new ChromeDriver();

    }
    @DataProvider
    public Iterator<Object[]> getData() throws Exception {
        String path = SearchProviderTest.class.getResource("/searchdata.csv").getPath();
        path = URLDecoder.decode(path,"utf-8");
        return readCsvFile(path);
    }



    @Test (dataProvider = "getData")
    private void searchTest(String s ) throws InterruptedException {
        //在浏览器输入地址


        driver.get("https://fxm5547.baobaobooks.com/");


        LoginFirstPage loginFirstPage = new LoginFirstPage(driver);
        loginFirstPage.searchClick();

        SearchPage searchPage = new SearchPage(driver);
        String expectGoodsName = "有试听 廖彩杏书单 英国进口 经典版鹅妈妈童谣合集 My Very First Mother Goose Pack 点读版【超大开本平装】";
        SearchResultPage searchResultPage = searchPage.gotoSearchResult(s);
        Thread.sleep(3000);

//        List<String> assertMsg = new ArrayList<String>();
//        int i = 1;
//        for(String goods_desc : searchResultPage.returnGoodsname()) {
//            System.err.println("正在校验第" + i++ + "条数据");
//            if(!goods_desc.contains(expectGoodsName)){
//                assertMsg.add("期待的标题不包含:" + expectGoodsName + ",实际的标题是:" + goods_desc +"\r\n");
//            }else {
//
//                System.out.printf("pass");
//            }
//        }
//
//        if(!assertMsg.isEmpty()) {
//            Assert.assertTrue(false, assertMsg.toString());
//        }

    }

//        读取CSV
        public Iterator<Object[]> readCsvFile(String path) throws Exception {
            List<Object[]> dataArray = new ArrayList<Object[]>();
            Reader in = new FileReader(path);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            for(CSVRecord record:records){
                List<Object> rowList = new ArrayList();
                Iterator i = record.iterator();
                while(i.hasNext()){
                    rowList.add(i.next());
                }
                Object[] rowArray = rowList.toArray();
                dataArray.add(rowArray);
            }
            return dataArray.iterator();
        }









    @AfterMethod
    private void teardown() {
        driver.quit();
    }

}

