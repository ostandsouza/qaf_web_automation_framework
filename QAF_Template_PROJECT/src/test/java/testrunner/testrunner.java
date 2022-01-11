package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "scenarios/web/LoginFeature.feature",
		glue = "com.web.steps"
		
		)


public class testrunner extends AbstractTestNGCucumberTests {

}
