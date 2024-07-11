package seleniumProgram;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class browserlanuch 
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       
        driver.get("https://www.fb.com");
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        WebElement wb = driver.findElement(By.id("email"));
        wb.sendKeys("testing@gmail.com");
        String at = wb.getAttribute("value");
        System.out.println(at);
    
        WebElement w = driver.findElement(By.name("pass"));
        w.sendKeys("Maha@17");
        String a = w.getAttribute("value"); // Changed 'wb' to 'w' to get the attribute of the password field
        System.out.println(a);
        
        WebElement w1 = driver.findElement(By.name("login"));
        w1.click();
        
        Thread.sleep(4000);
        WebElement w2 = driver.findElement(By.linkText("Forgotten password?"));
        w2.click();
        
       
        /*String b=driver.findElement(By.xpath("//h2[text()='Facebook helps you connect and share with the people in your life.']")).getText();
        System.out.println(b);
        WebElement e1 = driver.findElement(By.xpath("//h2[text()='Facebook helps you connect and share with the people in your life.']"));
        Thread.sleep(4000);
        System.out.println(driver.getTitle());

        String act=e1.getText(); 
       
        String exp="Facebook helps you connect and share with the people in your life.";
        if(act.equals(exp))
        	System.out.print("heading matched");
        else
         	System.out.print("not matched");*/
    }
}
