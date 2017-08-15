package features;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = "steps",
        format = { "pretty", "json:target/cucumber-html-reports/cucumber.json" })

public class RunFeatures {
}
