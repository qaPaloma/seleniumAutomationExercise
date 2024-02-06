package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunBase {
    static WebDriver driver;

    public enum Browser {CHROME, FIREFOX, EDGE, CHROME_HEADLESS}

    //Chooses a browser to execute the tests
    public static WebDriver getDriver() {

        String chooseBrowser = System.getProperty("browser");

        Browser browser = switch (chooseBrowser) {
            case "chrome" -> Browser.CHROME;
            case "firefox" -> Browser.FIREFOX;
            case "edge" -> Browser.EDGE;
            case "chrome-headless" -> Browser.CHROME_HEADLESS; //executes without opening the browser
            default -> throw new IllegalArgumentException("This browser is not supported");
        };

        if (driver == null) {
            return getDriver(browser); //Opens a browser if there's no browser already opened
        } else {
            return driver;
        }
    }

    //Executes after the browser is defined
    public static WebDriver getDriver(Browser browser) {

        if (driver != null) {
            driver.quit(); //closes the browser after a scenario was executed
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
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                throw new IllegalArgumentException("This browser is not supported");
        }
        return driver;
    }

}