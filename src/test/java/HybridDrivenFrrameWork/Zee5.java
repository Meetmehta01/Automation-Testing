package HybridDrivenFrrameWork;

import java.time.Duration;

import org.apache.xmlbeans.GDurationSpecification;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Zee5 {

	public static void main(String[] args) {
//		WebDriver w = new ChromeDriver();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.LINUX);
		RemoteWebDriver w = new RemoteWebDriver(dc);;
		
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Zee5Repo r = new Zee5Repo(w);
		w.get("https://www.zee5.com/");
		w.manage().window().maximize();
		r.Movie();
		r.play();
	}

}
