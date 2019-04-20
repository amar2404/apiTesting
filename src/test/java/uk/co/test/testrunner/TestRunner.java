package uk.co.test.testrunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        strict = true,
        dryRun = false,
        plugin = {
                "json:build/test-results/cucumber-repoerts/TestResults.json"
        },
        glue = "uk.co.argos.checkout.test.steps",
        features = "src/test/resources/features")
//        tags = {“@index”})


public class TestRunner {
    // YAMLConfig config = new YAMLConfig();

}
