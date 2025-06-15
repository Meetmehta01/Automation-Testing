package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RepoOfHotstar {
	WebDriver w;
	public RepoOfHotstar(WebDriver w) {
		this.w = w;
	}
	
	By Cancel = By.className("_1hU3TdoXFJGL0DTrPda9SF");
	By search = By.cssSelector("a[aria-label=\"My Space\"]");
	By login = By.xpath("//*[@id=\"page-container\"]/div/div[3]/div[1]/div/div[3]/div/button");
	By Mobile = By.cssSelector("input[title=\"Mobile number\"]");
	By OTP = By.cssSelector("button[data-testid=\"signup-form-submit-button\"]");
	By submitOtp = By.cssSelector("button[data-testid=\"otp-form-submit-button\"]");
	By SearchMovie = By.xpath("//*[@id=\"page-container\"]/div/div[2]/aside/nav/div[2]/a");
	By movie = By.cssSelector("input[placeholder=\"Movies, shows and more\"]");
	By watch = By.cssSelector("a[href=\"/in/movies/love-me-if-you-dare/1971011191/watch\"]");
	public void cancel() {
		
		w.findElement(Cancel).click();
	}
	public void MySpace() {
		w.findElement(search).click();
	}
	public void login() {
		w.findElement(login).click();
	}
	public void mobile() {
		w.findElement(Mobile).sendKeys("9892664503");
	}
	public void otp() {
		w.findElement(OTP).click();
	}
	public void submitotp() {
		w.findElement(submitOtp).click();
	}
	public void movie() {
		w.findElement(SearchMovie).click();
	}
	public void name() {
		w.findElement(movie).sendKeys("ove-me-if-you-dare");
	}
	public void watch() {
	WebElement watchnow = w.findElement(watch);
	Actions act = new Actions(w);
	act.moveToElement(watchnow).click(watchnow).perform();
	}	
}
