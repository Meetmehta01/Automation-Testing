package com.datadrivenframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDFDemo {

	public static void main(String[] args) throws Exception {
		
		WebDriver w = new ChromeDriver();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Lab-03-06\\Downloads\\Flipkart Data.xlsx");
		
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1;i<=sheet.getLastRowNum();i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell search = row.getCell(0);
			
			w.get("https://www.flipkart.com/");
			
			w.findElement(By.name("q")).sendKeys(search.toString(),Keys.ENTER);
			
			Thread.sleep(2000);
			
		}
		w.quit();
	}

}
