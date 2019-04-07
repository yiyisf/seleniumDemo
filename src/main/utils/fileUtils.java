import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuzhe on 2019/4/7.
 */
public class fileUtils {
    public  static  Iterator<Object[]> readCsvFile(String path) throws Exception {
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
}
