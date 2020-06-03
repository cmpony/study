

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExcelTest {

    @Test
    public void testExcel() {
        String path = "C:\\Users\\north\\Desktop\\picture.xlsx";
        // String path = "D:\\temp\\temp\\test.xlsx";
        File file = new File(path);
        InputStream is = null;
        Workbook workbook = null;
        try {
            is = new FileInputStream(file);
            if (path.endsWith(".xls")) {
                workbook = new HSSFWorkbook(is);
            } else if (path.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(is);
            }
            if (workbook != null) {
                int sheetCount = workbook.getNumberOfSheets();
                if (sheetCount > 0) {
                    // 文本内容
                    StringBuilder content = new StringBuilder();
                    for (int i = 0; i < sheetCount; i++) {
                        Sheet sheet = workbook.getSheetAt(i);
                        content.append(sheet.getSheetName());
                        for (int rownum = sheet.getFirstRowNum(); rownum <= sheet.getLastRowNum(); rownum++) {
                            Row row = sheet.getRow(rownum);
                            if (row == null || row.getFirstCellNum() < 0) {
                                break;
                            }
                            for (int columnnum = row.getFirstCellNum(); columnnum <= row
                                    .getLastCellNum(); columnnum++) {
                                String cellValue = getCellValue(row.getCell(columnnum));
                                content.append(cellValue);
                                if (content.length() > 500) {// 每500字输出一次
                                    System.out.println(content.toString());
                                    content.delete(0, content.length());
                                }
                            }
                        }
                    }
                    if (content.length() > 0) {
                        System.out.println(content.toString());
                    }

                    // 图片内容
                    List<?> pictures = workbook.getAllPictures();
                    if (pictures != null && !pictures.isEmpty()) {
                        for (int i = 0; i < pictures.size(); i++) {
                            PictureData picture = (PictureData) pictures.get(i);
                            byte[] data = picture.getData();
                            FileOutputStream out = new FileOutputStream(
                                    "D:\\" + UUID.randomUUID() + ".jpg");
                            out.write(data);
                            out.close();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            }
        }
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        // 都按文本格式读取
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }

}