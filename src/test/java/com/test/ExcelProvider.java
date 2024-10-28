package com.test;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ExcelProvider {
	@DataProvider(name = "excelData")
    public static Object[][] getExcelData() {
        String excelFilePath = "path/to/your/excel/file.xlsx";
        List<Object[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0) {
                    continue; // Skip header row
                }
                Object[] data = new Object[row.getLastCellNum()];
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    data[i] = row.getCell(i).toString();
                }
                dataList.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList.toArray(new Object[0][]);
    }
}

