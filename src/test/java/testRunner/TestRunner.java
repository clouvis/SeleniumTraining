package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C://Users//ClouvisDenosta//eclipse-workspace//SeleniumTrainingProject//Features/",
		glue = "stepDefinitions",
		dryRun = false,
		plugin = {"pretty",  "json:target/cucumber-reports/Cucumber.json",
						"junit:target/cucumber-reports/Cucumber.xml",
						"html:target/cucumber-reports.html"},
		monochrome = true,
		publish = true
		)
public class TestRunner {}
