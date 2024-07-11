package p1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepBy extends login
{
	@Given("user is on login page")
	public void user_is_on_login_page() 
	{
		browser_launch();
	}

	@When("^user enters valid username\"([^\"]*)\"$")
	public void user_enters_valid_username(String user) 
	{
		Enter_Email1(user);
	}

	@When("^user enters valid password\"([^\"]*)\"$")
	public void user_enters_valid_password(String pass) 
	{
		Enter_Password(pass);
	}
	
	
	
	
	
	
//	@When("user enters valid username")
//	public void user_enters_valid_username() 
//	{
//		Enter_Email1("testing@123");
//	}
//
//	@When("user enters valid password")
//	public void user_enters_valid_password() 
//	{
//		Enter_Password("12345678");
//	}

	@When("clicks on submit")
	public void clicks_on_submit()
	{
		submit();
	}

	@Then("user should be on home page")
	public void user_should_be_on_home_page() 
	{
		//browser_close();
	}
}
