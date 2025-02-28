package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="@failed_scenarios/failed_scenarios.txt",
		glue= {"com.stepDefinitions"})
public class FailedTestRerun extends AbstractTestNGCucumberTests {

}