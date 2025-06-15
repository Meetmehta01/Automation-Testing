package testCasesCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemo {
	WebDriver w;
	@Given("User launches ChromeBrowser.")
	public void user_launches_chrome_browser() {
	    w=new ChromeDriver();
	}

	@Given("User navigates to SauceDemo site.")
	public void user_navigates_to_sauce_demo_site() {
	   w.get("https://www.saucedemo.com/");
	}

	@When("User enters {string} in username feild.")
	public void user_enters_in_username_feild(String username) {
	   w.findElement(By.name("user-name")).sendKeys(username);
	}

	@When("User enters {string} in password feild.")
	public void user_enters_in_password_feild(String password) {
	   w.findElement(By.name("password")).sendKeys(password);
	}

	@When("User clicks on login button.")
	public void user_clicks_on_login_button() {
	   w.findElement(By.name("login-button")).click();
	}

	@Then("User verifies login by checking Web page url.")
	public void user_verifies_login_by_checking_web_page_url() {
	    Assert.assertEquals(w.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}

	@Then("User closes the Chrome browser.")
	public void user_closes_the_chrome_browser() {
	   w.quit();
	   
	}


}
