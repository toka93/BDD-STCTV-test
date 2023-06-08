package task;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class CucumberRunner {

	@CucumberOptions(tags = "", features = {
			"src/test/resources/ValidatePackagesForDifferentCountries.feature" }, glue = { "" }, plugin = {})

	public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

	}

}
