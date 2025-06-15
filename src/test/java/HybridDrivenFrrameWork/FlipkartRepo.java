package HybridDrivenFrrameWork;

import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartRepo {
	WebDriver w;
	public FlipkartRepo(WebDriver w) {
		PageFactory.initElements(w,this);
		this.w = w;
	}
	@FindBy(css = "input[name=\"q\"]") WebElement Search;
	@FindBy(className = "tUxRFH") WebElement SelectModel;
	@FindBy(className = "rPDeLR") WebElement SelectModel1;
	@FindBy(className = "VJA3rP") WebElement SelectModel2;
	@FindBy(css = "Button[class=\"QqFHMw vslbG+ In9uk2\"]") WebElement AddTocart;
	
	public void search(String item) {
		Search.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);;
		Search.sendKeys(item,Keys.ENTER);
	}
	public void Select() {
		try {
			SelectModel.click();
		} catch (Exception e) {
			try {
				SelectModel1.click();
			} catch (Exception e2) {
				try {
					SelectModel2.click();
				} catch (Exception e3) {
					SelectModel2.click();
				}
			}
		}
		
	}
	public void AddTocart() {
		Actions act = new Actions(w);
		act.moveToElement(AddTocart).click().perform();
	}
}
