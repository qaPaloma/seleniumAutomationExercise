package pages;

import org.openqa.selenium.By;
import runner.RunBase;
import static support.Commands.*;
import static support.UserDataUtils.*;
import static pages.CreateAccountPage.*;

public class LoginSignupPage extends RunBase {

    //region constants
    public static final String URL = "https://automationexercise.com/login";
    private final By LOGIN_EMAIL_FIELD = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    private final By PASSWORD_FIELD = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private final By ERROR_MESSAGE = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");
    private static final By NAME_FIELD = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private static final By SIGNUP_EMAIL_FIELD = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private static final By SIGNUP_BUTTON = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    private static final By ERROR_ACTUAL = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
    private static final String ERROR_EXPECTED = "Email Address already exist!";
    public static final String GET_FIRST_NAME = getRandomName.firstName();
    public static final String GET_LAST_NAME = getRandomName.lastName();
    public static final String GET_EMAIL = getRandomEmail();
    public final String GET_PASSWORD = storePassword();
    //endregion

    public static void pageCheck() {
        checkElementIsDisplayed(LOGIN_BUTTON);
    }

    /*---------*/
    public void addLoginEmail(String user) {
        fillField(LOGIN_EMAIL_FIELD, user);
    }

    public void addLoginPassword(String password) {
        fillField(PASSWORD_FIELD, password);
    }

    public void clickLoginButton() {
        clickButton(LOGIN_BUTTON);
    }

    public void errorMessageCheck(String message) {
        checkElementIsCorrect(ERROR_MESSAGE, message);
    }

    public void completeLogin() {
        enterWebPage(URL);
        pageCheck();
        addLoginEmail("testUser@test.com.br");
        addLoginPassword("test@Selenium123");
        clickLoginButton();
    }

    //Stores the user's name, so it can be used later
    // when checking if the name is correct on the create account
    // page and when checking if signup was successful
    public static String storeFirstName() {
        return GET_FIRST_NAME;
    }

    public static String storeLastName() {
        return GET_LAST_NAME;
    }

    public static String storeFullName() {
        return storeFirstName() + storeLastName();
    }

    public static void addName() {
        fillField(NAME_FIELD, storeFullName());
    }

    public static String storeEmail() {
        return GET_EMAIL;
    }

    public static void addSignupEmail() {
        fillField(SIGNUP_EMAIL_FIELD, storeEmail());
    }

    public static void clickSignupButton() {
        clickButton(SIGNUP_BUTTON);
    }

    public void trySignupWithExistingEmail(String arg0) {
        fillField(SIGNUP_EMAIL_FIELD, arg0);
    }

    public void errorMessageSignup() {
        checkElementIsCorrect(ERROR_ACTUAL, ERROR_EXPECTED);
    }

}
