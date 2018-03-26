package com.ht.common;

import com.ht.bean.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExportExcle {

    //获取数据
    public List<User> getlist() {
        List list = new ArrayList();
        User user1 = new User();
        user1.setId(3);
        user1.setUsername("name3");
        user1.setPassword("pass3");
        user1.setTel("333");
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setId(4);
        user2.setUsername("name4");
        user2.setPassword("pass4");
        user2.setTel("444");
        user2.setBirthday(Calendar.getInstance().getTime());
        list.add(user1);
        list.add(user2);
        return list;
    }

    //创建标题
    private static void writeTitle(Sheet sheet, String title) {
        Workbook workbook = sheet.getWorkbook();
        Row titleRow = sheet.createRow(0);
        Cell cell = titleRow.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short) 280);
        cellStyle.setFont(font);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(title);
    }

    //创建列名
    private static void writeHead(Sheet sheet, String[] columnNames) {
        Workbook workbook = sheet.getWorkbook();
        Row rowData = sheet.createRow(1);
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        for (int col = 0, len = columnNames.length; col < len; col++) {
            Cell cell = rowData.createCell(col);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(columnNames[col]);
        }
    }

    /**
     * 在指定工作表的指定位置插入图片
     * @param sheet 工作表
     * @param imagePath 图片路径
     * @param leftDX 图片在单元格中离左上角的x距离
     * @param topDY 图片在单元格中离左上角的y距离
     * @param widthDX 图片的宽度
     * @param heightDY 图片的高度
     * @param beginRow 图片开始的行
     * @param beginCol 图片开始的列
     * @param endRow 图片结束的行
     * @param endCol 图片结束的列
     */
    public static void insertPicture(Sheet sheet, String imagePath,
                                     int leftDX, int topDY, int widthDX ,int heightDY,
                                     int beginRow, int beginCol, int endRow, int endCol) {
        Workbook workbook = sheet.getWorkbook();
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor clientAnchor = workbook.getCreationHelper().createClientAnchor();
        clientAnchor.setDx1(leftDX);
        clientAnchor.setDy1(topDY);
        clientAnchor.setDx2(widthDX);
        clientAnchor.setDy2(heightDY);
        clientAnchor.setRow1(beginRow);
        clientAnchor.setCol1(beginCol);
        clientAnchor.setRow2(endRow);
        clientAnchor.setCol2(endCol);
        try {
            drawing.createPicture(clientAnchor,
                    workbook.addPicture(IOUtils.toByteArray(new FileInputStream(imagePath)), Workbook.PICTURE_TYPE_PNG));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPicture(Workbook workbook) throws IOException {
        List<PictureData> lst = (List<PictureData>) workbook.getAllPictures();
        for (Iterator it = lst.iterator(); it.hasNext(); ) {
            PictureData pict = (PictureData)it.next();
            String ext = pict.suggestFileExtension();
            byte[] data = pict.getData();
            if (ext.equals("jpeg")){
                FileOutputStream out = new FileOutputStream("pict.jpg");
                out.write(data);
                out.close();
            }
        }
    }


    //读取数据
    public void ReaderUser() throws Exception {
        List<User> list = getlist();
        //创建工作簿
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");
        writeTitle(sheet, "**公司员工通讯录");
        writeHead(sheet, new String[]{"编号", "姓名","密码", "手机号", "生日", "头像"});
        for(int i=2;i<list.size()+2;i++) {
            Row row = sheet.createRow(i);
            Cell cell0 = row.createCell(0);
            Cell cell1 = row.createCell(1);
            Cell cell2 = row.createCell(2);
            Cell cell3 = row.createCell(3);

            cell0.setCellValue(list.get(i-2).getId());
            cell1.setCellValue(list.get(i-2).getUsername());
            cell2.setCellValue(list.get(i-2).getPassword());
            cell3.setCellValue(list.get(i-2).getTel());

            CreationHelper createHelper = wb.getCreationHelper();
            CellStyle cellStyle = wb.createCellStyle ();
            cellStyle.setDataFormat(
            createHelper.createDataFormat().getFormat("yyyy/MM/dd"));
            Cell cell4 = row.createCell(4);
            cell4.setCellStyle(cellStyle);
            cell4.setCellValue(list.get(i-2).getBirthday());

            insertPicture(sheet, "src/main/resources/6.png", 0, 0, 300, 300, i, 5,  i + 1, 6);
        }
        wb.write(new FileOutputStream("src/main/resources/c.xlsx"));
        wb.close();
    }

    public static void main (String []  args) throws Exception {
        ExportExcle ee = new ExportExcle();
        System.out.println("开始读取数据。。。");
        ee.ReaderUser();
    }
}
