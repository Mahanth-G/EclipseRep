package seleniumProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtables 
{
	
	
	public static WebDriver driver;
	
	static int rows,columns;
	public static void browser_launch()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://testingmasters.weebly.com/webtables.html");
		 rows = driver.findElements(By.xpath("//table[@id='VisitingTable']//tr")).size();
		System.out.println("Total no of rows "+rows);
		
		columns=driver.findElements(By.xpath("//table[@id='VisitingTable']//th")).size();
		System.out.println("Total no of columns "+columns);
		
		String rec1=driver.findElement(By.xpath("//table[@id='VisitingTable']//tr[4]//td[5]")).getText();
		System.out.println(rec1);//printing specific record
		System.out.println();
		
	}
	

	public static void print_headers()
	{
		
		List<WebElement>headers=driver.findElements(By.xpath("//table[@id='VisitingTable']/thead/tr[1]/th"));
		
		for(int i=0;i<=headers.size()-1;i++)
		{
			System.out.println(headers.get(i).getText());
		}
	}
	
	
	public static void print_Emids_Analyst()
	{
		
		List<WebElement>Anlaystids=driver.findElements(By.xpath("//table[@id='VisitingTable']/tbody/tr/td[5][text()='Analyst']/preceding-sibling::td[3]"));
		
		for(int i=0;i<=Anlaystids.size()-1;i++)	
		{
			System.out.println(Anlaystids.get(i).getText());
		}
	}
	
	public static void ReadindData()
	{
		
		for(int r=2; r<rows; r++)
		{
			for(int c=1; c<columns; c++)
			{
				String rec=driver.findElement(By.xpath("//table[@id='VisitingTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(rec+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public static void Analys()
	{
		for(int r=1; r<=12; r++)
		{
			String des=driver.findElement(By.xpath("//table[@id='VisitingTable']//tr["+r+"]//td[5]")).getText();
			//System.out.println(des);
			if(des.equals("Analyst"))
			{
				String sid=driver.findElement(By.xpath("//table[@id='VisitingTable']//tr["+r+"]//td[2]")).getText();
				System.out.println(sid);
			}
			
		}
		
	}
	
	
	public static void print_Emids_leaveslessthan5()
	{
		
		List<WebElement>Anlaystids=driver.findElements(By.xpath("//table/tbody/tr/td[7][text()<5]/preceding-sibling::td[5]"));
			
		for(int i=0;i<=Anlaystids.size()-1;i++)
		{
			System.out.println(Anlaystids.get(i).getText());
		}
	}
	public static void Ana()
	{
		List<WebElement> id=driver.findElements(By.xpath("//table[@id='VisitingTable']//tbody//tr//td[5]"));
		for(int i=0; i<id.size(); i++)
			System.out.println(id.get(i).getText());
		
	}
	public static void browser_close()
	{
		driver.close();
	}

	public static void main(String[] args)
	{
		browser_launch();
		//ReadindData();
		//Ana();
		 Analys();
		//print_Emids_Analyst();
		//print_Emids_leaveslessthan5();
		 driver.close();
		//driver.quit();

	}

}