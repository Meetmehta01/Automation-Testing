package com.TestNG;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Cross_browsing {
	Logger log;
	WebDriver w;
	@Parameters ("crossbrowsing")
	@BeforeClass
	public void launchbrowser(String browser) {
		log = LogManager.getFormatterLogger();
		if (browser.equals("firefox")) {
			w=new FirefoxDriver();
			log.info("Firefox is opened");
		}else if (browser.equals("chrome")) {
			w=new ChromeDriver();
			log.info("Chrome is opened");
		}else {
			System.out.println("Invalid browse name : "+browser);
			}		
		}
	@BeforeMethod
	public void gotourl() {
		w.get("https://www.flipkart.com/");
		log.info("User has loaded flipkart url");
	}
	@Test(dataProviderClass = DataProviderForTesting.class,dataProvider = "flipkartforsearchdata")
	public void search(String search) throws Exception {
		w.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		log.info("User has provided "+search+" content in serarch tab and has entered ");
		Thread.sleep(5000);
	}
	@AfterClass
	public void quit() {
		w.quit();
		log.info("User has quit browser");
	}
}
