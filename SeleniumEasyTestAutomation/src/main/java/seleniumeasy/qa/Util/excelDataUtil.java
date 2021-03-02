package seleniumeasy.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import seleniumeasy.qa.Base.Base;

public class excelDataUtil extends Base
{
	static File file;
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	
	public static XSSFWorkbook openExcelFile(String sFile)
	{
		file = new File(sFile);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook;
		
	}
	
	public static Object[][] readExcelFile(String sSheetName)
	{
		XSSFSheet sheet;
		
		int rowCount;
		int colCount;
		Object data[][];
		
		String sFile = System.getProperty("user.dir") +  prop.getProperty("TestDataFile_Excel");
		XSSFWorkbook workbook=openExcelFile(sFile);
		sheet = workbook.getSheet(sSheetName);
		rowCount = sheet.getPhysicalNumberOfRows()-1;
		colCount = sheet.getRow(0).getLastCellNum();
		data = new Object[rowCount][colCount];
		int iSkipTopRow=1;
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				data[i][j] = sheet.getRow(iSkipTopRow).getCell(j).toString();
				//System.out.print(data[i][j] + "-");

			}
			System.out.println();
			iSkipTopRow++;
		}
		
		closeExcelConnection();
		return data;
	}
	public static void closeExcelConnection()
	{
		try {
			
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
