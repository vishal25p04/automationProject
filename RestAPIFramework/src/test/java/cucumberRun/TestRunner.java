package cucumberRun;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue={"stepDefinations"},
		tags = "@AddPlace"
//		dryRun=true
		)
public class TestRunner {

}
