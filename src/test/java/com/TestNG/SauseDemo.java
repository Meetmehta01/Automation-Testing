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
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauseDemo {
	WebDriver w;
	SauceDemoRepoTestNG r;
	@BeforeClass
	public void launchchrome() {
		w=new EdgeDriver();
		r= new SauceDemoRepoTestNG(w);
	}
	@BeforeMethod
	public void oepnsite() {
		w.get("https://www.saucedemo.com/");
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@Test  (priority = 1)
	public void login() throws Exception {
		r.Username("standard_user");
		Thread.sleep(2000);
		r.password("secret_sauce");
		Thread.sleep(2000);
		r.login();
		Thread.sleep(2000);
	}
	
	@Test  (priority = 2)
	public void logout () throws Exception {
		r.Username("standard_user");
		Thread.sleep(2000);
		r.password("secret_sauce");
		Thread.sleep(2000);
		r.login();
		Thread.sleep(2000);
		r.Burger();
		Thread.sleep(2000);
		r.Logout();
	}
	@AfterClass
	public void quit() {
		w.quit();
	}

}