package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//		plugin = {"com.qmetry.qaf.automation.cucumber.QAFCucumberPlugin", "pretty", "html:target", "timeline:target"},
		features = {"scenarios/Web/Demoflow.feature"},
		glue = {"classpath:com.web.steps"},
		tags = "@Regression"
		)


public class testrunner extends AbstractTestNGCucumberTests {

}
