package myexcel.read.xlsx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 读取xslx文件类
 * @author weixin
 * @data 18/01/13
 */
public class XlsxRead {
    private String FilePath;
    private File file;
    private Boolean isExists;
    private String[] keyList;
    private int workbookNumber;

    /**
     * 默认解析本工程的这个文件
     */
    public XlsxRead() {
        FilePath = "白名单模板(1).xlsx";
        keyList = new String[]{"uname", "idcard", "mobile", "creditMoney", "level"};
        this.addFile();
    }

    /**
     * 可以添加新的文件来解析
     *
     * @param filePath
     */
    public XlsxRead(String filePath, String[] keyList) {
        this.FilePath = filePath;
        this.keyList = keyList;
        this.addFile();
    }

    //设置文件路径
    private void addFile() {
        file = new File(FilePath);
        if (!file.exists()) {
            System.out.print("没有找到这个文件");
            isExists = false;
        } else {
            System.out.println("文件已经找到");
            isExists = true;
        }
    }

    /**
     * 获取文件中的所有数据
     * @return
     */
    public List<Map<String, Object>> getValue(int workbookNo) {
        List<Map<String, Object>> result = new ArrayList<>();
        InputStream inputStream=null;
        try {
            //获取文件输入流
            inputStream = new FileInputStream(file);
            //获取excel的文件表
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            workbookNumber = xssfWorkbook.getNumberOfSheets();
            if (workbookNumber >= workbookNo) {
                XSSFSheet sheet = xssfWorkbook.getSheetAt(workbookNo);
                if (null != sheet) {
                    //获取当前工作的每一行
                    for (int rowNumber = 0; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                        Map<String, Object> row = getRowCellValue(sheet, rowNumber);
                        result.add(row);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    /**
     * 获取文件中一行的数据
     * 不暴露的私有函数
     *
     * @return
     */
    private Map<String, Object> getRowCellValue(XSSFSheet sheet, int rowNumber) {
        //获取当前工作簿德一行
        XSSFRow row = sheet.getRow(rowNumber);
        Map<String, Object> result = new HashMap<>();
        //
        XSSFCell cell;
        String key;
        //循环去读每一列的数据，将他们放入到map中
        for (int cellNumber = 0; cellNumber <= row.getLastCellNum(); cellNumber++) {
            cell = row.getCell(cellNumber);
            if (null != cell) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    result.put(keyList[cellNumber], cell.getStringCellValue());
                    //System.out.println("该数据是【CELL_TYPE_STRING】类型的"+cell.getStringCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                    result.put(keyList[cellNumber], cell.getNumericCellValue());
                    //System.out.println("该数据是【CELL_TYPE_BLANK】类型的"+cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                    result.put(keyList[cellNumber], cell.getBooleanCellValue());
                    //System.out.println("该数据是【CELL_TYPE_BOOLEAN】类型的"+cell.getBooleanCellValue());
                } else if(DateUtil.isCellDateFormatted(cell)){
                    result.put(keyList[cellNumber], cell.getDateCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    result.put(keyList[cellNumber], cell.getNumericCellValue());
                    //System.out.println("该数据是【CELL_TYPE_NUMERIC】类型的"+cell.getNumericCellValue());
                } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                    result.put(keyList[cellNumber], cell.getCellFormula());
                    //System.out.println("该数据是【CELL_TYPE_FORMULA】类型的"+cell.getCellFormula());
                }
            }
        }
        return result;
    }

    /**
     * 获取设置的返回key值列
     */
    public String[] getKeyList() {
        return keyList;
    }

    /**
     * 设置新的key值列
     */
    public void setKeyList(String[] keyList) {
        this.keyList = keyList;
    }

    /**
     * 获取文件中某一行的数据
     * 向外提供的函数接口
     */
    public Map<String, Object> getRowValue(int workbookNo,int rowNumber) {
        Map<String, Object> result = new HashMap<>();
        InputStream inputStream=null;
        try {
            //获取文件输入流
            inputStream = new FileInputStream(file);
            //获取excel的文件表
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            workbookNumber = xssfWorkbook.getNumberOfSheets();
            if (workbookNumber >= workbookNo) {
                XSSFSheet sheet = xssfWorkbook.getSheetAt(workbookNo);
                if (null != sheet&&sheet.getLastRowNum()>=rowNumber) {
                    //获取这一行的数据
                    result=getRowCellValue(sheet,rowNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }
}
