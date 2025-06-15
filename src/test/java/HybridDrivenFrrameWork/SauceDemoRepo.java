package HybridDrivenFrrameWork;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoRepo {
	public SauceDemoRepo(WebDriver w) {
		PageFactory.initElements(w,this);
	}
	@FindBy(id = "user-name") WebElement Username;
	@FindBy(id = "password") WebElement Password;
	@FindBy(css = "input[class=\"submit-button btn_action\"]") WebElement LoginBtn;
	@FindBy(css = "button[class=\"btn btn_primary btn_small btn_inventory \"]") WebElement AddToCart;
	@FindBy(className = "shopping_cart_link")WebElement GoToCart;
	@FindBy(xpath = "/html/body/div/div/div/div[2]/div/div[2]/button[2]")WebElement Checkout;
	@FindBy(css = "input[id=\"first-name\"]")WebElement Firstname;
	@FindBy(css = "input[id=\"last-name\"]")WebElement Lastname;
	@FindBy(css = "input[id=\"postal-code\"]")WebElement Pincode;
	@FindBy(css = "input[id=\"continue\"]")WebElement Continue;
	@FindBy(css = "button[id=\"finish\"]")WebElement Finish;
	@FindBy(id = "react-burger-menu-btn") WebElement BurgerBtn;
	@FindBy(id = "logout_sidebar_link") WebElement LogoutBtn;

	public void Username(String user) {
		Username.sendKeys(user);
	}
	public void ClearUsername() {
		Username.clear();
	}
	public void ClearPassword() {
		Password.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);;
	}
	public void password(String pass) {
		Password.sendKeys(pass);
	}
	public void login() {
		LoginBtn.click();
	}
	public void AddTocart() {
		AddToCart.click();
	}
	public void GoToCart() {
		GoToCart.click();
	}
	public void Checkout() {
		Checkout.click();
	}
	public void firstname() {
		Firstname.sendKeys("Meet");
	}
	public void lastname() {
		Lastname.sendKeys("Mehta");
	}
	public void pincode() {
		Pincode.sendKeys("400086");
	}
	public void Continue() {
		Continue.click();
	}
	public void Finish() {
		Finish.click();
	}
	public void Burger() {
		BurgerBtn.click();
	}
	public void Logout() {
		LogoutBtn.click();
	}
}
