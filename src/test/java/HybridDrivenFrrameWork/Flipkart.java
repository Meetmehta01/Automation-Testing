package HybridDrivenFrrameWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws Exception {
		WebDriver w = new ChromeDriver();
		FlipkartRepo r = new FlipkartRepo(w);
		w.get("https://www.flipkart.com/");
		w.manage().window().maximize();
		FileInputStream fls = new FileInputStream("C:\\Users\\Lab-03-06\\Desktop\\Flipkart.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fls);
		XSSFSheet sheet= work.getSheetAt(0);
		for (int i = 1; i <= 4; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(0);
			String parent2 = null;
			for (int j = 1; j <= 3; j++) {
				XSSFRow Rowstep = sheet.getRow(j);
				XSSFCell TestStep = Rowstep.getCell(1);
				try {
					switch (TestStep.toString()) {
					case "Search Product":
						r.search(cell.toString());
						break;
					case "Open product":
						r.Select();
						String Parent = w.getWindowHandle();
						parent2 = Parent;
						Set<String>child = w.getWindowHandles();
						for (String c : child) {
							if (!c.equals(Parent)) {
								w.switchTo().window(c);
							}
						}
					break;
					case "Add to cart":
						r.AddTocart();
						w.close();
						w.switchTo().window(parent2);
						

					default:
						System.out.println("Invalid Steps :"+TestStep.toString());
						break;
					}
				} catch (Exception e) {
					
				}
			}
		}
	}

}
