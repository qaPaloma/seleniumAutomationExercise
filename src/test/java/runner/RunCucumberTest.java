package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/report.html", "json:target/cucumber/report.json"},
        features = "src/test/resources/features",
        //tags = "@delete-account",
        glue = {"steps"}
)

public class RunCucumberTest extends RunBase {

   @AfterClass
    public static void stop() {
        driver.quit();
    }

}
