package com.datadrivenframework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleDataDriven {

	public static void main(String[] args) throws Exception {
		
WebDriver w = new ChromeDriver();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Lab-03-06\\Downloads\\Untitled spreadsheet.xlsx");
		
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for(int i = 1;i<=sheet.getLastRowNum();i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			
			w.get("https://demo.frontaccounting.eu/");
			
			w.findElement(By.name("user_name_entry_field")).clear();
			Thread.sleep(2000);
			w.findElement(By.name("user_name_entry_field")).sendKeys(username.toString());
			Thread.sleep(2000);
			w.findElement(By.name("password")).clear();
			Thread.sleep(2000);
			w.findElement(By.name("password")).sendKeys(password.toString());
			Thread.sleep(2000);			
			w.findElement(By.name("SubmitUser")).click();
			Thread.sleep(2000);

			try {
				w.findElement(By.linkText("Logout")).click();
			}
				
			 catch (Exception e) {
				// TODO: handle exception
			}
			
		
	}
		w.quit();

}
}
