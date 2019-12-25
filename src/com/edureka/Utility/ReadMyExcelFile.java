package com.edureka.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadMyExcelFile {
	
		
	public static String[][] getData(String filename,String SheetName) throws IOException {
		File file = new File(filename);
		FileInputStream f_in= new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(f_in);		
		Sheet sh = wb.getSheet(SheetName);
		int rowNum = sh.getLastRowNum() + 1;
		int colNum = sh.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];
		System.out.println(rowNum);
		System.out.println(colNum);
		for(int i = 0;i<rowNum;i++)
		{
			Row rowdata = sh.getRow(i);
			for(int j=0;j< colNum; j++)
			{
				Cell cell= rowdata.getCell(j);
				String cellvalue = new DataFormatter().formatCellValue(cell);
				
				data[i][j] = cellvalue;
				System.out.println(data[i][j]);
			}
		}
		return data;	
		
		
	}

}
