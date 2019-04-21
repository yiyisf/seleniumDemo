import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuzhe on 2019/2/20.
 */
public class testNGTest_ReadExcel {
    @DataProvider
    public Object[][] getData(){
        String path  = this.getClass().getResource("data.xlsx").getPath();
        System.out.println(path);
        return getDataFromExcel(path);

    }

    @Test(dataProvider="getData")
    public void testProcess1(String username,String password){
        System.out.println(username);
        System.out.println(password);
    }


    public Object[][] getDataFromExcel(String excelPath) {
        //HSSFWorkbook针对xls，XSSFWorkbook针对xlsx；
        //XSSFWorkbook、XSSFSheet、XSSFRow、XSSFCell为2007+版本对应的处理实现类；
        //HSSFWorkbook、HSSFSheet、HSSFRow、HSSFCell为97-2003版本对应的处理实现类；
        Workbook workbook;
        try {
            FileInputStream excelInputStream = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(excelInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int rowInExcel = sheet.getPhysicalNumberOfRows();
            int columnInExcel = sheet.getRow(0).getPhysicalNumberOfCells();
            String[][] obj = new String[rowInExcel-1][columnInExcel];
            for(int row = 1; row < rowInExcel; row++){
                for(int col = 0; col < columnInExcel; col++){
                    sheet.getRow(row).getCell(col).setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
                    obj[row - 1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
                    System.out.println(obj[row - 1][col]);

                }
            }
            return obj;
        }catch(Exception e){
            throw new SkipException(e.getMessage());
        }

    }





}

