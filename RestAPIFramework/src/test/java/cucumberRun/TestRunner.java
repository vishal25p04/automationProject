package cucumberRun;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue={"stepDefinations"},
		plugin = {"json:target/jsonReports/cucumber-report.json","html:target/htmlReports/cucumber-report.html"}
//		tags = "@DeletePlace"
//		dryRun=true
		)
public class TestRunner {

}
