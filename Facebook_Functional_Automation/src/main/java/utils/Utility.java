package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utility{
	
	public static String getDataFromExcelSheet(String sheetName, int rowNo,int cellNo) throws EncryptedDocumentException, IOException 
	{
		String getCellData;
		String path ="D:\\Jagdish Bhondekar\\OneDrive\\Desktop";
	    InputStream file = new FileInputStream(path);
	    Cell fromCell= WorkbookFactory.create(file).getSheet(sheetName).getRow(rowNo).getCell(cellNo);
	    
	    try
	    {
	    	getCellData = fromCell.getStringCellValue();
	    }
	    catch(Exception e)
	    {
	    	double numericCellValue = fromCell.getNumericCellValue();
	    	int i=(int)numericCellValue;
	    	getCellData = Integer.toString(i);
	    }
		return getCellData;
	}
	
	public static void captureScreenShot(String testID) throws IOException
	{
		TakesScreenshot driver = null;
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date now = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyy_MM_dd_HH_mm_ss");
		String formatedDateTime = dateformat.format(now);
		File dest = new File ("./photo/" + testID +"_" + formatedDateTime+ ".png");
		FileUtils.copyDirectory(source, dest);
	}

}
