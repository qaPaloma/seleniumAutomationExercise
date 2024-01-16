package support;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import runner.RunCucumberTest;

public class ScreenshotUtils extends RunCucumberTest {

    public static void takeScreenshot(Scenario scenario){
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Scenario failed");
    }
}
