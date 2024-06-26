package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class TestUtil {
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public static String TESTDATA_SHEET_PATH = "D:\\Eclips_Main\\Instagram_Functional_Automation\\src\\main\\java\\testdata\\LoginTestData.xlsx";
    
	public static Object[][] getTestData(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=null;
		try
		{
			file= new FileInputStream(TESTDATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book= WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet =  book.getSheet(SheetName);
		Object[][] data = new Object [sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		for(int i=0;i < sheet.getLastRowNum(); i++)
		{
			for(int k=0; i< sheet.getRow(0).getLastCellNum(); k++)
			{
			data [i] [k]=sheet.getRow(i +1).getCell(k).toString();
			}
		}
		 return data;
	}
}
