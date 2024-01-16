package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunBase {
    static WebDriver driver;

    public enum Browser {CHROME, FIREFOX, EDGE}

    //Opens a new browser
    public static WebDriver getDriver() {

        String chooseBrowser = System.getProperty("browser");
        Browser browser = switch (chooseBrowser) {
            case "chrome" -> Browser.CHROME;
            case "firefox" -> Browser.FIREFOX;
            case "edge" -> Browser.EDGE;
            default -> throw new IllegalArgumentException("This browser is not supported");
        };

        if (driver == null) {
            return getDriver(browser);
        } else {
            return driver;
        }
    }

    //Executes after getDriver is defined and closes the browser
    public static WebDriver getDriver(Browser browser) {

        if (driver != null) {
            driver.quit();
        }

        switch (browser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("This browser is not supported");
        }
        return driver;
    }

}
