package runner;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
                 glue= {"stepdefinitions","hooks"},
                 publish=true,
                 plugin={"pretty","html:target/CucumberReports/CucumberReport.html",
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                 })
                		 //"json:target/cucumber.json"})
                		 
                 
                	//	 "json:target/CucumberReports/CucumberReport.json" })
public class TestRunner extends AbstractTestNGCucumberTests { 

	
}
