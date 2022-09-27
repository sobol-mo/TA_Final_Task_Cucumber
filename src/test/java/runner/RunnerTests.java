package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Features",
        glue = "stepdefinitions"/*,
        tags = "@smoke and @singin"*/
)
public class RunnerTests {

}
