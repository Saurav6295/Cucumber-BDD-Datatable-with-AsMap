package TestRunner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "G:\\Automation testing\\HandsOn\\Datadriven with asMap\\july28_3\\src\\main\\java\\Feature\\Feature.feature"
,glue= {"StepDefinition"}
,dryRun=false
,monochrome=true
,strict=true
		)
public class TestRunner {

}