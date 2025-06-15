package pom;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class MyntraWithPageFactory {
	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		RepoOfMyntra r = new RepoOfMyntra(w);
		w.get("https://www.myntra.com/");
		w.manage().window().maximize();
		Thread.sleep(2000);
		r.Search("Shoes");
		Thread.sleep(2000);
		r.product();
		String Parent = w.getWindowHandle();
		Set<String> child = w.getWindowHandles();
		for (String c : child) {
			if (!c.equals(Parent)) {
				w.switchTo().window(c);
				Thread.sleep(2000);
				r.size();
				Thread.sleep(2000);
				r.AddToCart();
				Thread.sleep(2000);
			}
		}
		w.quit();
	}
}
