package p1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class login extends C1
{
	//WebElement e=driver.findElement(By.xpath("//*[@id='email']"));
	 public static By EmailID=By.id("email");////*[@id='email']
	 public static By password=By.name("pass");
	 public static By submit=By.name("login");
	 
	 public static void Enter_Email1(String emailId)
	 {
		 driver.findElement(EmailID).sendKeys(emailId);
		 //e.sendKeys("emailId);
	 }
	 public static void Enter_Password(String passId)
	 {
		 driver.findElement(password).sendKeys(passId);
	 }
	 public static void submit()
	 {
		 driver.findElement(submit).click();
	 }
	 
}
