package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGFestures {
	
	
	@Test (priority = 1,invocationCount = 3)
	public void facebook() {
		WebDriver w = new ChromeDriver();
		w.get("https://www.facebook.com/");
	}
	@Test (priority = 2)
	public void amazon() {
		WebDriver w = new ChromeDriver();
		w.get("https://www.amazon.in/");
	}
	
}
