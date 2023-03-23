package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin", "pretty", "timeline:target"},
		features = {"scenarios/Web/Demoflow.feature"},
		glue = {"com.web.steps"},
		tags = "@Regression"
		)


public class testrunner extends AbstractTestNGCucumberTests {

}
