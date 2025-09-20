package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber", glue="Step_Defination", monochrome=true)
public class TestNGtestRunner extends AbstractTestNGCucumberTests{
	
}
