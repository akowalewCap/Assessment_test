package com.example.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = { "com.example.steps" }, 
		plugin = { "pretty", "html:Reports/cucumber-test-report.html" },
        dryRun = true // checks if all the steps have the step definition
		)
public class TestRunner {
}