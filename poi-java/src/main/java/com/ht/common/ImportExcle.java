package com.ht.common;



import com.ht.bean.User;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;


public class ImportExcle {

    public void readXls() throws Exception{
        Workbook workbook = new XSSFWorkbook(new FileInputStream("src/main/resources/user.xlsx"));
        Sheet sheet = workbook.getSheet("Sheet1");
        for (int row = 1, lastRowNum = sheet.getLastRowNum(); row <= lastRowNum; row++) {
            Row rowData = sheet.getRow(row);
            User contact = new User();
            for (int col = 0; col < 5; col++) {
                Cell cell = rowData.getCell(col);
                if (col == 0) {
                    contact.setId((int) cell.getNumericCellValue());
                } else if (col == 1) {
                    contact.setUsername(cell.getStringCellValue());
                } else if (col == 2) {
                    contact.setPassword(cell.getStringCellValue());
                } else if (col == 3) {
                    //contact.setTel(cell.getStringCellValue());
                } else if (col == 4) {
                    contact.setBirthday(cell.getDateCellValue());
                }
            }
            System.out.println(contact);
        }
        workbook.close();
    }

    public void ReaderExcle() throws Exception{
        Workbook wb = new XSSFWorkbook(new FileInputStream("src/main/resources/user.xlsx"));
        //创建工作簿
        Sheet sheet = wb.getSheet("Sheet1");
        User user = new User();
        for (int row=1;row<=sheet.getLastRowNum();row++){
            Row row1 = sheet.getRow(row);
            Cell cell0 = row1.getCell(0);
            Cell cell1 = row1.getCell(1);
            Cell cell2 = row1.getCell(2);
            Cell cell3 = row1.getCell(3);
            Cell cell4 = row1.getCell(4);
            user.setId((int)cell0.getNumericCellValue());
            user.setUsername(cell1.getStringCellValue());
            user.setPassword(cell2.getStringCellValue());
            user.setTel(cell3.getStringCellValue());
            user.setBirthday(cell4.getDateCellValue());
            System.out.println("工作簿： "+user);
        }

        wb.close();
    }

    public static void main(String[] args) throws Exception {
        ImportExcle ii = new ImportExcle();
        System.out.println("开始。。。");
        //ii.readXls();
        ii.ReaderExcle();
    }
}
