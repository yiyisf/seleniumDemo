import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuzhe on 2019/2/20.
 */
public class testNGTest_ReadCSV {
    @DataProvider
    public Iterator<Object[]> getData(){
        String path  = this.getClass().getResource("data.csv").getPath();
        System.out.println(path);
        return readDataFromCSV(path);

    }

    @Test(dataProvider="getData")
    public void testProcess1(String username,String password){
        System.out.println(username);
        System.out.println(password);
    }


    public Iterator<Object[]> readDataFromCSV(String path){
        List<Object[]> list = new ArrayList<Object[]>();
        try {
            FileReader is = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(is);
            while(br.ready()){
                list.add(br.readLine().split(","));
            }
            return list.iterator();
        }catch(Exception ex){
            throw new SkipException(ex.getMessage());
        }
    }




}

