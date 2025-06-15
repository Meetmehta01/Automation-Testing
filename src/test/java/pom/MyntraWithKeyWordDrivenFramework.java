package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraWithKeyWordDrivenFramework {

	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		RepoOfMyntra r = new RepoOfMyntra(w);
		w.get("https://www.myntra.com/");
		w.manage().window().maximize();
		
		FileInputStream fls = new FileInputStream("‪‪./test.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fls);
		XSSFSheet sheet = work.getSheetAt(1);
		for (int i = 1; i <=sheet.getLastRowNum();  i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(0);
			String steps = cell.toString();
			
			switch (steps) {
			case "Search an product":
				r.Search("Shoes");
				break;
			case "Click on first product":
				r.product();
				String Parent = w.getWindowHandle();
				Set<String> child = w.getWindowHandles();
				for (String c : child) {
					if (!c.equals(Parent)) {
						w.switchTo().window(c);
					}
				}
				break;
			case "click on size":
				r.size();
				break;
			case "click on add to bag":
				r.AddToCart();
				break;
				default:
					System.out.println("Invalid steps : "+steps);
				
				
			}
		}
	}

}
