package pom;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepoOfFlipkart {
	WebDriver w;

	public RepoOfFlipkart(WebDriver w) {
		this.w = w;
	}

	By search = By.name("q");
	By product = By.className("CGtC98");
	By page = By.xpath("//span[contains(text(),'Next')]");
	By addtocart = By.cssSelector("button[class=\"QqFHMw vslbG+ In9uk2\"]");
	By addtocartlogo = By.cssSelector("button[class=\"QqFHMw vslbG+ In9uk2 JTo6b7\"]");

	public void EnterSearchValue (String search) {
		w.findElement(this.search).sendKeys(search,Keys.ENTER);
	}
	public void ClearSearchValue() {
		w.findElement(search).clear();
	}

	String pd;
	public void SelectProduct(String ProductName) {
		List<WebElement> pro = w.findElements(product);
		for (WebElement p : pro) {
			if (p.getText().contains(ProductName)) {
				pd = p.getText();
				p.click();
				break;
			}
		}
	}

	public void NextPage() {
		w.findElement(page).click();
	}
	public void WindowHandle() {
		String parentwindow = w.getWindowHandle();
		this.parent = parentwindow;
		Set<String>Child = w.getWindowHandles();
		for (String c : Child) {
			if (!c.equals(parentwindow)) {
				w.switchTo().window(c);
			}	
		}
	}
	String parent;
	public void AddToCart() {
		try {
			w.findElement(addtocart).click();
		} catch (Exception e) {
			w.findElement(addtocartlogo).click();
		}
	}
	public void SwitchToMainParent() {
		w.switchTo().window(parent);
	}
	public void close() {
		w.close();
	}
}

