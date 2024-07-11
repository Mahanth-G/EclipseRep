package seleniumProgram;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Frames 
{
	public static void frame1() throws InterruptedException 
	{
		    WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://demo.guru99.com/test/guru99home/");
	        Thread.sleep(5000);
	        driver.switchTo().frame("a077aa5e");
	        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
	        Thread.sleep(7000);
	        driver.switchTo().defaultContent();
	        driver.findElement(By.xpath("//*[@id='philadelphia-field-email']")).sendKeys("maha");
	        
	}
	public static void frame2() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		
		List<WebElement>allframes=driver.findElements(By.tagName("iframe"));
		System.out.println(allframes.size());
		
		for(int i=0;i<allframes.size();i++)
		{
			driver.switchTo().frame(i);
			if(driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).isEnabled())
			{
				driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
			}
		
		}
	}
	
	public static void frame2_updat()
	{
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/guru99home/");
        List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total iframes: " + allFrames.size());
        for (int i = 0; i < allFrames.size(); i++) 
        {
            driver.switchTo().frame(i);
            try 
            {
               
                WebElement imgElement = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
                if (imgElement.isEnabled()) 
                {	
                	System.out.println("element found at "+i);
                	imgElement.click();
                    //break; 
                }
            } 
            catch (Exception e) 
            {
                
                System.out.println("Element not found in iframe " + i);
            }
            finally
            {
           
                driver.switchTo().defaultContent();
            }
        }
	}
		public static void main(String[] args) throws InterruptedException 
		{	
			frame1();
			 //frame2();
			//frame2_updat();
		}
}


