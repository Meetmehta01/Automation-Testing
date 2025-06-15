package testCasesCode;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartCucumber {
	WebDriver w;
	@Given("User has launched ChromeBrowser.")
	public void user_has_launched_chrome_browser() {
	   w = new ChromeDriver();
	}

	@Given("User has navigated to Flipkart.")
	public void user_has_navigated_to_flipkart() {
	   w.get("https://www.flipkart.com/");
	}

	@When("User search {string} in search element.")
	public void user_search_in_search_element(String search) throws Exception {
	   w.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
	   Thread.sleep(2000);
	}

	@Then("Verify the {string} of the page")
	public void verify_the_of_the_page(String exptitle) throws Exception {
	   Assert.assertEquals(w.getTitle().contains(exptitle), true);
	   Thread.sleep(2000);
	}

	@Then("Close the browser.")
	public void close_the_browser() {
	   w.quit();
	}
}
