package stepdefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinition",
        plugin = {"pretty", "json:target/cucumber.json"},
        tags = ("@Regression"),
        monochrome = false)
public class CucumberRunnerTest {

}
