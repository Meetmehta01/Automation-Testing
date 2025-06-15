package HybridDrivenFrrameWork;

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

public class SauseDemo {

	public static void main(String[] args) throws Exception {
		WebDriver w = new EdgeDriver() ;
		w.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		SauceDemoRepo r = new SauceDemoRepo(w);
		w.get("https://www.saucedemo.com/");
		w.manage().window().maximize();
		FileInputStream fls = new FileInputStream("C:\\Users\\Lab-03-06\\Desktop\\SauseDemo New test Data.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(fls);
		XSSFSheet sheet = work.getSheetAt(0);
		for (int i = 1; i <=6 ; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell Userandpass = row.getCell(0);
			String arr[] = Userandpass.toString().split(",");
			for (int j = 1; j <= 10
					; j++) {
				XSSFRow RowStep = sheet.getRow(j);
				XSSFCell TestStep = RowStep.getCell(1);
				try {
					switch (TestStep.toString()) {
					case "Enter Username":
						r.Username(arr[0]);

						break;
					case "Enter Password":
						r.password(arr[1]);

						break;
					case "Click on Login button":
						r.login();
						Thread.sleep(2000);
						break;
					case "Click on Add to cart":

						r.AddTocart();
						break;
					case"Click on Cart Logo":
						r.GoToCart();
						break;
					case"Click on Checkout":
						r.Checkout();
						break;
					case"Enter Firstname,Lastname and pincode":
						r.firstname();
						r.lastname();
						r.pincode();
						break;
					case"Click on continue button":
						r.Continue();
						break;
					case"Click on finish button":
						r.Finish();
						break;
					case "Click on burger button and click on logout":
						r.Burger();
						r.Logout();

						break;

					default:
						System.out.println("Invalid steps "+TestStep.toString());
						break;
					}
				} catch (Exception e) {
					TakesScreenshot tss = (TakesScreenshot) w;
					FileHandler.copy(tss.getScreenshotAs(OutputType.FILE),new File("./Screenshot/"+arr[0]+".png"));
					r.ClearUsername();
					r.ClearPassword();
				}
			}
		}
	}

}
