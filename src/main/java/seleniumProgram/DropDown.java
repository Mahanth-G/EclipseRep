package seleniumProgram;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown 
{
	static WebDriver driver;
	public static void dropDown()
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement we=driver.findElement(By.xpath("//select[@name='country']"));
		Select dropdown=new Select(we);
		//dropdown.selectByValue("INDIA");
		
		List<WebElement>allValues=dropdown.getOptions();
		System.out.print(allValues.size());
		
		for(int i=0; i<allValues.size(); i++)
		{
			System.out.println(allValues.get(i).getText());
			if("JAPAN".equals(allValues.get(i).getText()))
			{
				dropdown.selectByVisibleText("JAPAN");
				break;
			}
			
		}
		
	}
	 public static void alerts()
	 {
	        driver.get("https://demo.guru99.com/test/delete_customer.php");
	        driver.findElement(By.xpath("//input[@name='submit']")).click();
	        if (driver.switchTo().alert().getText().endsWith("Do you really want to delete this Customer?")) 
	        {
	            driver.switchTo().alert().accept();
	            driver.switchTo().alert().accept();
	        } 
	        else 
	        {
	            driver.switchTo().alert().accept();
	        }
	    }
	
	


	public static void main(String[] args) 
	{
		
		 driver=new ChromeDriver();
		//dropDown();
		  alerts();
	}

}
