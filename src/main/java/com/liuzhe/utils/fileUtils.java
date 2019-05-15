package com.liuzhe.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public static String readYmlFile(String path,String attribute) throws Exception{
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream(path);
        Map map = yaml.loadAs(fileInputStream, Map.class);
        fileInputStream.close();
        return (String)map.get(attribute);
    }

    public static Map readYmlFile(String path) throws Exception{
        Yaml yaml = new Yaml();
        FileInputStream fileInputStream = new FileInputStream(path);
        Map map = yaml.loadAs(fileInputStream, Map.class);
        return map;
    }

    public static void main(String[] args)throws Exception{
        String path = getPath("/clickBanner.yaml");
        String value = readYmlFile(path,"expectTitle");
        System.out.printf(path);
        System.out.printf(value);
    }

    public static String getPath(String partPath) throws Exception{
        String path = fileUtils.class.getResource(partPath).getPath();
        return URLDecoder.decode(path,"UTF-8");
    }
}
