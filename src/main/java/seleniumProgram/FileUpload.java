package seleniumProgram;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// Resume upload in naukri 
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=23531&wExp=N&utm_source=google&utm_medium=cpc&utm_campaign=Brand&gad_source=1&gclid=EAIaIQobChMI_Jq6w839hgMVT6NmAh3shgtOEAAYASAAEgKmePD_BwE&gclsrc=aw.ds");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(text(), 'experienced')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@class,'uploadResume')]")).click();
		Runtime.getRuntime().exec("C:\\autoit\\script1.exe");
	}
 
}
