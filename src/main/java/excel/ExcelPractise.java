package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPractise 
{
	
	public static void Reading_Data() throws IOException
	{
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\excel1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
				
				XSSFSheet sheet=wb.getSheet("Sheet1");//or 	XSSFSheet sheet=wb.getSheetAt(0 or 1 0r 2 or any);
				int rows=sheet.getLastRowNum();
				int cellCount=sheet.getRow(1).getLastCellNum();
				
				System.out.println("total rows "+rows);
				System.out.println("total cells "+cellCount);
				
				//printing all rows cell data in a sheet
				
				for(int r=0; r<=rows; r++)
				{
					XSSFRow currentRow=sheet.getRow(r);
					
					for(int c=0; c<cellCount; c++)
					{
						XSSFCell cell=currentRow.getCell(c);
						System.out.print(cell.toString()+"\t");//in sheets amount is in integer but in the console we are getting float 
					}
					System.out.println();
				}
				wb.close();
				file.close();
		
	}
	public static void Writing_Data() throws IOException
	{
		FileOutputStream fout=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet1=workbook.createSheet("Data");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("how many rows do you want? ");
		int noOfRows=sc.nextInt();
		System.out.println("how many cells do you want? ");
		int noOfCells=sc.nextInt();
		
		for(int r=0; r<=noOfRows; r++)
		{
			XSSFRow currentRow=sheet1.createRow(r);
			for(int c=0; c<noOfCells; c++)
			{
				XSSFCell Cell=currentRow.createCell(c);
				Cell.setCellValue(sc.next());
				
			}
		}
		workbook.write(fout);
		workbook.close();
		fout.close();
		System.out.println("file created");
	}
	public static void main(String []args) throws IOException
	{
		//Reading_Data();
		Writing_Data();	
	}
}
