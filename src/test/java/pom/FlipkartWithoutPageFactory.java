package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartWithoutPageFactory {

	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		w.get("https://www.flipkart.com/");
		w.manage().window().maximize();
		RepoOfFlipkart f =new RepoOfFlipkart(w);

		f.EnterSearchValue("mobile");

		
		while (true) {
			w.navigate().refresh();
			f.SelectProduct("Infinix Hot 50 5G (Vibrant Blue, 128 GB)");
			try {
				if (f.pd.contains("Infinix Hot 50 5G (Vibrant Blue, 128 GB)")) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			w.navigate().refresh();
			f.NextPage();
		}

		Thread.sleep(2000);
		f.WindowHandle();
		Thread.sleep(2000);
		f.AddToCart();
		Thread.sleep(2000);
		f.close();
		f.SwitchToMainParent();
		Thread.sleep(2000);
		f.close();


	}

}
