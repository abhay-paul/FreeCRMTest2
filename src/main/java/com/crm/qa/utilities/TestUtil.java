package com.crm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.BaseClass;

public class TestUtil extends BaseClass {
	public static String uniquescreenshotfolder;
	static Workbook book;
	static Sheet sheet;
	static String TESTDATA_SHEET_PATH = "E:\\Dev\\Speed400Journey\\FreeCRMTest\\FreeCRMTest2\\src\\main\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx";

	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		// will iterate the excel sheet using two for loops

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
//				if(sheet.getRow(i+1).getCell(i).getCellType()==CellType.STRING) {
//					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
//				}
//				else if(sheet.getRow(i+1).getCell(i).getCellType()==CellType.NUMERIC){
//					data[i][j] = NumberToTextConverter.toText(sheet.getRow(i + 1).getCell(j).getNumericCellValue());
//				}
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	public static void takeScreenshot(String methodName) {
		
		if(uniquescreenshotfolder==null) {
			LocalDateTime localDateTime= LocalDateTime.now();
			DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			uniquescreenshotfolder=localDateTime.format(dateTimeFormatter);
			System.out.print(uniquescreenshotfolder);
		}
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("E:\\Dev\\Speed400Journey\\FreeCRMTest\\"
					+ "FreeCRMTest2\\Screenshot\\"+uniquescreenshotfolder+"\\"+methodName));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}




