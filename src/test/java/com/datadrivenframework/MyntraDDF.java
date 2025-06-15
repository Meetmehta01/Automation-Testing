package com.datadrivenframework;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class MyntraDDF {
	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		w.get("https://www.myntra.com/");
		w.manage().window().maximize();
		FileInputStream fis = new FileInputStream("C:\\Users\\Lab-03-06\\Downloads\\Mynta data.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.getSheet("Sheet1");
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell search = row.getCell(0);
			w.findElement(By.className("desktop-searchBar")).sendKeys(search.toString(),Keys.ENTER);
			Thread.sleep(2000);
			w.findElement(By.className("product-product")).click();
			Thread.sleep(2000);
			String ParentWindow = w.getWindowHandle();
			Set<String>multiwindow = w.getWindowHandles();
			for (String mw : multiwindow) {
				if (!mw.equals(ParentWindow)) {
					w.switchTo().window(mw);
					try {
						w.findElement(By.xpath("//*[@class=\"size-buttons-size-buttons\"]/div[1]")).click();
					} catch (Exception e) {
						w.findElement(By.xpath("//*[@class=\"size-buttons-size-buttons\"]/div[2]")).click();
						try {
							w.findElement(By.xpath("//*[@class=\"size-buttons-size-buttons\"]/div[2]")).click();	
						} catch (Exception e2) {
							w.findElement(By.xpath("//*[@class=\"size-buttons-size-buttons\"]/div[3]")).click();
						}
					}
					Thread.sleep(2000);
					w.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[3]/div/div[1]")).click();
					Thread.sleep(2000);
					w.close();
					w.switchTo().window(ParentWindow);
				}
			}
		}
		w.quit();
	}
	
	
	
}
