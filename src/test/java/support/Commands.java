package support;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;
import java.time.Duration;
import java.util.Random;

public class Commands extends RunCucumberTest {

//Methods created to perform several actions in the code

    private static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public static void waitElement(By element) {
        getWait().until(driver -> ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitClickable(By element) {
        getWait().until(driver -> ExpectedConditions.elementToBeClickable(element));
    }

    /*---------*/
    public static void clickButton(By element) {
        System.out.println("##########################");
        System.out.println("Will click on the button");
        try {
            waitClickable(element);
            getDriver().findElement(element).click();
            System.out.println("The " + element + " button was clicked");
        } catch (Exception error) {
            System.out.println("**** An error occurred when trying to click the " + element);
        }
    }

    /*---------*/
    public static void fillField(By element, String value) {
        System.out.println("##########################");
        System.out.println("Will fill a field with a value");
        try {

            waitElement(element);
            getDriver().findElement(element).sendKeys(value);
        } catch (Exception error) {
            System.out.println("**** An error occurred when trying to fill in the field " + element);
        }
    }

    /*---------*/
    public static void enterWebPage(String URL) {
        try {
            getDriver().get(URL);
            getDriver().manage().window().maximize();
        } catch (Exception error) {
            System.out.println("**** An error occurred when trying to enter " + URL);
        }
    }

    /*---------*/
    public static String getRandomNumber(int numberOfDigits){
        return RandomStringUtils.randomNumeric(numberOfDigits);
    }

    public static int getRandomNumber(int minValue, int maxValue){
        Random random = new Random();

        return random.nextInt(maxValue - minValue) + minValue;
    }

    public static void selectOption(By element1, By element2){
        System.out.println("##########################");
        System.out.println("Will select an option");
        String option = String.valueOf(getRandomNumber(1, 2));
        System.out.println("Selected option " + option);
        switch (option) {
            case "1":
                clickButton(element1);
                break;
            case "2":
                clickButton(element2);
                break;
            default:
                System.out.println("**** Element not found");
        }
    }

    /*
    public static void dismissIFrame(By element1, By  element2){
        System.out.println("##########################");
        System.out.println("Will try to locate and dismiss add");
        try {
            waitLonger(60);
            getDriver().switchTo().frame(getDriver().findElement(element1));
            waitLonger(30);
            getDriver().findElement(element2).click();
            getDriver().switchTo().defaultContent();
        } catch (Exception error) {
            System.out.println("**** Add was not displayed");
        }
    }
    */

    /*---------*/
    public static void checkElementIsCorrect(By elementActual, String valueExpected) {
        try {
            waitElement(elementActual);
            WebElement element = getDriver().findElement(elementActual);
            if (element.getAttribute("value") != null) {
                // Method 1: Element with a "value" attribute. Ex.: Filled forms
                String valueActual = element.getAttribute("value");
                Assert.assertEquals(valueExpected, valueActual);
            } else {
                // Method 2: Element without a "value" attribute but with text. Ex. Titles
                String actual = element.getText();
                Assert.assertEquals(valueExpected, actual);
            }
        } catch (Exception error) {
            System.out.println("**** An error occurred when trying to verify the element");
        }
    }

    /*---------*/
    public static void checkElementIsDisplayed(By element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement elementDisplayed = getDriver().findElement(element);
        assert elementDisplayed.isDisplayed() : "**** Element is not displayed";
    }

    public static boolean elementException(By element) {
        try {
            WebElement elementDisplayed = getDriver().findElement(element);
            return elementDisplayed.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static void elementPresentError(By element){
        assert !elementException(element) : "**** Element is still present";
    }

    public static void checkElementIsNotPresent(By element){
        elementPresentError(element);
        elementException(element);
    }

}