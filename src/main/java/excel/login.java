package excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import excel.BaseClass;
import lombok.val;
public class login extends BaseClass
{
	 public static By EmailID=By.id("email");////*[@id='email']
	 public static By password=By.name("pass");
	 public static By submit=By.name("login");
	 public static By validation= By.xpath("//*[@id=\"email_container\"]/div[2]");
	 
	 public static void Enter_Email1(String emailId)
	 {
		 driver.findElement(EmailID).sendKeys(emailId);
		 //e.sendKeys("emailId);  not working
	 }
	 public static void Enter_Password(String passId)
	 {
		 driver.findElement(password).sendKeys(passId);
	 }
	 public static void submit()
	 {
		 driver.findElement(submit).click();
	 }
	 public static boolean ErrorMessage_Validation()
	 {
		String act_msg=driver.findElement(validation).getText();
		System.out.println(act_msg);
		
		String exp_msg="The email address you entered isn't connected to an account. Find your account and log in.";
	
		if(act_msg.equals(exp_msg))
		{
			return true;
		}
		else
			return false;
		 
	 }
	
	 
	 
}
