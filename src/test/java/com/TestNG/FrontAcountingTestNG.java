package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrontAcountingTestNG {

	WebDriver w;
	
	@BeforeClass
	public void launchbrowser() {
		w=new ChromeDriver();
	}
	@BeforeMethod
	public void opensite() {
		w.get("https://demo.frontaccounting.eu/");
	}
	
	@Test
	public void login() {
		w.findElement(By.name("SubmitUser")).click();
	}
	@Test
	public void logout() {
		w.findElement(By.linkText("Logout")).click();
	}
	@AfterClass
	public void quit() {
		w.quit();
	}
}
