package HybridDrivenFrrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zee5Repo {
	public Zee5Repo(WebDriver w) {
		PageFactory.initElements(w, this);
	}
	@FindBy(css ="div[class=\"movieCard card marginRight minutelyUrl zoomCardHover \"]") WebElement Movie;
	@FindBy(className = "playBtn")WebElement Play;
	
	public void Movie() {
		Movie.click();
	}
	public void play() {
		Play.click();
	}
	
}
