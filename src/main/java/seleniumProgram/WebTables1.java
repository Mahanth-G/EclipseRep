package seleniumProgram;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables1 
{
	
	
	public static WebDriver driver;
	public static void browser_launch()
	{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.get("http://testingmasters.weebly.com/webtables.html");
	}
	public static void Allcheck()
	{
		List<WebElement> all=driver.findElements(By.xpath("//table[@id='VisitingTable']/tbody/tr/td/input[@name='item1']"));
		for(int i=0; i<all.size(); i++)
		{
			all.get(i).click();
		}
	}
	public static void chec5k()
	{
		List<WebElement> all=driver.findElements(By.xpath("//table[@id='VisitingTable']/tbody/tr/td/input[@name='item1']"));
		//tbody/tr/td[1] is also correct,if we delete or modify any rows in the given table ,then td[1] changes.Hence td/input[]used.
		for(int i=0; i<6; i++)
		{
			all.get(i).click();
		}
		//clicking first 5 without using position function
	}
	public static void first_5check()
	{
		
		List<WebElement>Managers=driver.findElements(By.xpath("(//td[1])[position()<=5]"));
		//(//table[@id='VisitingTable']/tbody/tr/td[1])[position()<=5],both xpaths are same.If 2 checkboxes are there in given table then use 2nd approach(using table name)
		
		for(int i=0;i<=Managers.size()-1;i++)
		{
			Managers.get(i).click();
		}
	}
	public static void vinod_Analyst()
	{
			List<WebElement>vn=driver.findElements(By.xpath("//table[@id='VisitingTable']/tbody/tr/td[5][text()='Analyst']/preceding-sibling::td[2][text()='Vinod']/preceding-sibling::td[1]"));
			for(int i=0; i<vn.size(); i++)
			{
				System.out.println(vn.get(i).getText());
				//printing ids whose name is vinod and designation is Analyst
			}
	}

	public static void Click_manager_checkbox()
	{
		
		List<WebElement>Managers=driver.findElements(By.xpath("//table[@id='VisitingTable']/tbody/tr/td[5][text()='Manager']/preceding-sibling::td/input"));
		
		for(int i=0;i<=Managers.size()-1;i++)
		{
			Managers.get(i).click();
		}
	}

	
	public static void Last_sixcheckbox()
	{
		List<WebElement>allcheckboxes =driver.findElements(By.xpath("//td[1]"));
	
		for(int i=allcheckboxes.size();i>=allcheckboxes.size()-5;i--)
		{
			driver.findElement(By.xpath("(//td[1])[position()="+i+"]"  )).click();
			//clicking last 6 with using position function 
		}
	}
	public static void last6()
	{
		List<WebElement> al=driver.findElements(By.xpath("//table[@id='VisitingTable']/tbody/tr/td/input[@name='item1']"));
		for(int i=al.size()-1;i>=al.size()-5;i--)
		{
			al.get(i).click();
			//clicking last 6 without using posotion function 
		}
		
		
	}
	public static void Rejected_ID()
	{
		
		List<WebElement>Managers=driver.findElements(By.xpath("//table[@id='VisitingTable']/tbody/tr/td[8]/select/option[text()='Accepted' and @selected='selected']/parent::select/parent::td/preceding-sibling::td[6]"));
		//instead of above u can use this//table[@id='VisitingTable']/tbody/tr/td[8]/select/option[text()='Accepted' and @selected='selected']/ancestor::td/preceding-sibling::td[6]
		
		for(int i=0;i<=Managers.size()-1;i++)
		{
			System.out.println(Managers.get(i).getText());
		}
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
	
	
	public static void print_Emids_leaveslessthan5()
	{
		
		List<WebElement>Anlaystids=driver.findElements(By.xpath("//table/tbody/tr/td[7][text()<5]/preceding-sibling::td[5]"));
		
		for(int i=0;i<=Anlaystids.size()-1;i++)
		{
			System.out.println(Anlaystids.get(i).getText());
		}
	}
	
	public static void browser_close()
	{
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException
	{
		browser_launch();
		Thread.sleep(6000);
		//Click_manager_checkbox();
		//chec5k();
		//Allcheck();
		//first_5check();
		//Last_sixcheckbox();
		//last6();
		//Rejected_ID();
		vinod_Analyst();
		//driver.close();
		//driver.quit();
	}

}
