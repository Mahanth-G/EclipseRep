package seleniumProgram;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class action 
{
	public static ChromeDriver driver;
	public static void dragAndDrop() 
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(driver);
		WebElement source=driver.findElement(By.xpath("//li[@data-id='5']/a"));
		WebElement target=driver.findElement(By.xpath("//ol[@id='bank']/li"));
		act.dragAndDrop(source, target).build().perform();

		
	}
	public static void doubleClick() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement link=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions act=new Actions(driver);
		act.doubleClick(link).perform();
		Thread.sleep(4500);
		driver.switchTo().alert().accept();
		
		
		
		
	}
	public static void conTextClick()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement source=driver.findElement(By.xpath("//li[@data-id='5']/a"));
		Actions act=new Actions(driver);
		act.contextClick(source).build().perform();	
	}
	public static void hover()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.browserstack.com/guide/action-class-in-selenium");
		Actions act=new Actions(driver);
		WebElement link=driver.findElement(By.xpath("//button[@id='developers-dd-toggle']" ));
		act.moveToElement(link).build().perform();
		WebElement innerlink=driver.findElement(By.xpath("//a[@title='Release Notes']"));
		innerlink.click();
		
	}
	public static void keyboardActions() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("VIRATKOHLI");
		Actions act=new Actions(driver);
		Thread.sleep(4000);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		act.keyDown(Keys.TAB);
		act.perform();
		

		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
	}
	public static void main(String[] args) throws InterruptedException 
	{
		//launch();
		//dragAndDrop();
		//conTextClick();
		//hover();
		//doubleClick();
		keyboardActions();

	}

}
