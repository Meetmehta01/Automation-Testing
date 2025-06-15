package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotstarWithoutPageFactory {

	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		RepoOfHotstar r = new RepoOfHotstar(w);
		w.get("https://www.hotstar.com/in/mypage");
		w.manage().window().maximize();
		//r.cancel();
		//Thread.sleep(2000);
		//r.MySpace();
		//Thread.sleep(2000);
		r.login();
		Thread.sleep(2000);
		r.mobile();
		r.otp();
		Thread.sleep(10000);
		r.submitotp();
		Thread.sleep(2000);
		r.movie();
		Thread.sleep(2000);
		r.name();
		Thread.sleep(3000);
		r.watch();
		
	}

}
