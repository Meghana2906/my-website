package runnerfiles;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Cucumber runner configuration
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/restapidemo.feature",
        glue = {"Stepfiles"},
        plugin = { "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        publish = false
)

public class TestRunnerApi {
}
