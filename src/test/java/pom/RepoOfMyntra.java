package pom;
import java.awt.RenderingHints.Key;
import java.awt.print.PageFormat;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RepoOfMyntra {
	public RepoOfMyntra(WebDriver w) {
		PageFactory.initElements(w, this);
	}
	@FindBy(css = "input[placeholder=\"Search for products, brands and more\"]")
	WebElement Search;
	@FindBy(css = "h4[class=\"product-product\"]") WebElement product;
	@FindBy(css = "button.size-buttons-size-button.size-buttons-size-button-default")
	WebElement size;
	@FindBy(css = "div.pdp-add-to-bag.pdp-button.pdp-flex.pdp-center")
	WebElement AddToCart;
	public void Search(String search) {
		this.Search.sendKeys(search,Keys.ENTER);
	}
	public void product() {
		this.product.click();
	}
	public void size() {
		this.size.click();
	}
	public void AddToCart() {
		this.AddToCart.click();
	}
}
