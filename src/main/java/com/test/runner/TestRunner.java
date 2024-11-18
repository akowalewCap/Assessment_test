package com.test.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features", 
		glue = { "com.test.steps" }, 
		plugin = { "pretty",
		"html:Reports/cucumber-test-report.html" }, 
		monochrome = false, 
		dryRun = true)
public class TestRunner {
}