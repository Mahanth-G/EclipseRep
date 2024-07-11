package seleniumProgram;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindHandle 
{
	public static void main(String []args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.naukri.com/");
		String parentId=driver.getWindowHandle();
		Thread.sleep(4000);
		System.out.println(parentId);
		//Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='acceptance-btn']")).click();
		driver.findElement(By.xpath("//span[@title='Remote']")).click();
		Set<String>allWindows=driver.getWindowHandles();
		System.out.println(allWindows);
		
		for(String currentwind:allWindows)
		{
			if(!currentwind.equals(parentId))
			{
				driver.switchTo().window(currentwind);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[@title='Work from office']")).click();
				System.out.println(driver.getTitle());
				Thread.sleep(5000);
				//driver.close();
				driver.switchTo().window(parentId);
				Thread.sleep(5000);
			}
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='MNC']")).click();
		
		
		
	}
}
