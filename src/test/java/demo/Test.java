package demo;

import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import HybridDrivenFrrameWork.Zee5Repo;

public class Test {

	public static void main(String[] args) throws Exception {
		for(int i = 1;i<=20;i++) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("firefox");
		
				dc.setPlatform(Platform.LINUX);


			
			RemoteWebDriver w = new RemoteWebDriver(dc);
			
			w.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			Zee5Repo r = new Zee5Repo(w);
			w.get("https://www.zee5.com/");
			Thread.sleep(5000);
			
		}

	}

}
