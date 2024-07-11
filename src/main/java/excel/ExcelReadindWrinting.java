package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadindWrinting extends login 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String emailId = "";
		String pass = "";
		
		String path="C:\\Users\\MANEESH\\OneDrive\\Desktop\\Tyn\\excel.xlsx";
		
		FileInputStream f=new FileInputStream(path);
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
		
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
		System.out.println("total rows = "+rows);
		for(int i=1; i<=rows; i++)
		{
			XSSFRow row=sheet.getRow(i);
			
			emailId=row.getCell(0).getStringCellValue();
			System.out.println(emailId);
			pass=row.getCell(1).getStringCellValue();
			System.out.println(pass);
			
			browser_launch();
			Enter_Email1(emailId);
			Enter_Password(pass);
			submit();
			Thread.sleep(3000);
			boolean b=ErrorMessage_Validation();
			System.out.println(b);
			
			int cellCount=sheet.getRow(i).getLastCellNum();
			XSSFCell cell=row.createCell(cellCount);
			
			if(ErrorMessage_Validation()==true)
			{
				cell.setCellValue("pass");
				
			}
			else
				cell.setCellValue("fail");
			
		}
		f.close();
		FileOutputStream fout=new FileOutputStream(path);
		wb.write(fout);
		fout.close();
	}
}
