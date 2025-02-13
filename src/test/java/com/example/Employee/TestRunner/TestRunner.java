package com.example.Employee.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue = "com.example.Employee.stepDefinitions",
		tags = "@employee",
		plugin = {"pretty", "html:target/cucumber-report.html"

		}
)
class TestRunner {


}
