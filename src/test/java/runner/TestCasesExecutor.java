package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "TestCases",
		glue = "testCasesCode",
		plugin = "html:Report/cucumberreport.html",
		tags = "@flipkart"
		)

public class TestCasesExecutor extends AbstractTestNGCucumberTests{

}
