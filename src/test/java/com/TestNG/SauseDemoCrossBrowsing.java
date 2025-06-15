package com.TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauseDemoCrossBrowsing {
	WebDriver w;
	SauceDemoRepoTestNG r;
	@Parameters ("Crossbrowsing")
	@BeforeClass
	public void launchchrome(String browser) {
		if (browser.equals("firefox")) {
			w=new FirefoxDriver();
		}else if (browser.equals("chrome")) {
			w=new EdgeDriver();
		}
		r= new SauceDemoRepoTestNG(w);
	}
	@BeforeMethod
	public void oepnsite() {
		w.get("https://www.saucedemo.com/");
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@Test  (dataProviderClass = SauseDemoDataProvider.class,dataProvider = "sauseDemoLogin")
	public void login(String username,String password) throws Exception {
		r.Username(username);
		Thread.sleep(2000);
		r.password(password);
		Thread.sleep(2000);
		r.login();
		Assert.assertEquals(w.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		Thread.sleep(2000);
	}
	@AfterMethod
	public void logout () throws Exception {
		try {
			r.Burger();
			Thread.sleep(2000);
			r.Logout();
		} catch (Exception e) {
		}

	}
	@AfterClass
	public void quit() {
		w.quit();
	}
}