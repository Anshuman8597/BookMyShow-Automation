package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/features/movieSearch.feature", 
		glue= { "stepdefinitions", "hooks" },
//		dryRun = true ,
//		tags = "@ValidCitySearch",
		plugin = { "pretty", "html:reports/cucumber.html","json:reports/cucumber.json" }, 
		monochrome = true
				)
public class TestRunner extends AbstractTestNGCucumberTests {
}