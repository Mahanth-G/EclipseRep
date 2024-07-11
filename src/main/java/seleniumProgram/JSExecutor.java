package seleniumProgram;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
public class JSExecutor 
{
	public static void selectParticularLink() 
	{
		//scrolling and clicking on particular link with out usind sendkeys method
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.amazon.in/");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.scrollBy(0,900)");//scrolls down(+)
			//js.executeScript("window.scrollBy(0,-10000)");//scrolls up(-)
			WebElement sellon=driver.findElement(By.xpath("//*[text()='Sell on Amazon']"));
			js.executeScript("arguments[0].scrollIntoView();",sellon);
		    System.out.println(js.executeScript("return window.pageYOffset;"));
	        //how much the scollbar is moves
			js.executeScript("arguments[0].click();",sellon);
	}
    public static void sendKeys() throws InterruptedException 
    {
   
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	driver.get("https://www.amazon.in/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement keys = driver.findElement(By.xpath("//*[@name='field-keywords']"));
            String dress = "wrangler Jeans";
            js.executeScript("arguments[0].value='" + dress + "';", keys);
            WebElement search = driver.findElement(By.xpath("//div/span/input[@value='Go']"));
        	js.executeScript("arguments[0].scrollIntoView();",search);//this stmt needed /not needed
            //js.executeScript("arguments[0].click();", search);
    }
    public static void nopCommerce() 
    {
    	 	WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://demo.nopcommerce.com/");
	        JavascriptExecutor js=driver;
	        WebElement ele=driver.findElement(By.xpath("//*[text()='Featured products']"));
	        js.executeScript("arguments[0].scrollIntoView();", ele);
	        System.out.println(js.executeScript("return window.pageYOffset;"));
	        //how much the scollbar is moves
    
    }
    public static void main(String[] args) throws InterruptedException
    {
    	selectParticularLink() ;
        //sendKeys();
    	//nopCommerce() ;
    }
}
