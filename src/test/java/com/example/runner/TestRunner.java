package com.example.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = { "com.example.steps" }, 
		plugin = { "pretty", "html:Reports/cucumber-test-report.html" }, 
		monochrome = false, 
		dryRun = true
		)
public class TestRunner {
}