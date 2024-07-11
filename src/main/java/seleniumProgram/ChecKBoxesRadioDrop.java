package seleniumProgram;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChecKBoxesRadioDrop 
{

	static 	WebDriver driver;
	public static void check_box() throws InterruptedException
	{
		List<WebElement>cb=driver.findElements(By.xpath("//input[@type='checkbox' and @name='webform']"));
		//strong[text()='Checkbox']
		//searching for checkbox(bold heading) (or)
	
		/*for(int i=0; i<cb.size(); i++)
		{
			cb.get(i).click();
			// selecting all check boxes
		}*/
		
		/*
		for(int i=0; i<cb.size(); i++)
		{
			String name=cb.get(i).getAttribute("value");
			System.out.println(name);
			// retreving all the names of checkboxes
		}*/
		for(int i=0; i<cb.size(); i++)
		{
			//uncliking the clicked one
			String name=cb.get(i).getAttribute("value");
			if(name.equals("checkbox2"))
			{
				Thread.sleep(4000);
				if(cb.get(i).isSelected())
				{
					System.out.println("It is selected Already");
				}
				else
					cb.get(i).click();
			}
		}
		
		
	}
	public static void radio_button()
	{
		
		List<WebElement>ra=driver.findElements(By.xpath("//div[@style='margin-left:20px;']/input[@type='radio' and @name='webform']"));
		for(int i=0; i<ra.size(); i++)
		{
			//System.out.println(ra.get(i).getAttribute("Value"));
			//printing all names of radio buttons
		}
		driver.findElement(By.xpath("//input[@type='radio'  and @value='Option 2']")).click();
			
	}
	public static void drop_down()
	{
		
	}
	public static void main(String[] args) throws InterruptedException 
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/radio.html");	
		//check_box();
		radio_button();
		//driver.get("https://www.google.com/");		
	}

}
