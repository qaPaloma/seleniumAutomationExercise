package pages;

import org.openqa.selenium.By;
import runner.RunBase;
import static pages.LoginSignupPage.*;
import static support.Commands.*;

public class HomePage extends RunBase {

    //region constants
    public static final String URL = "https://automationexercise.com/";
    private static final By LOGIN_SIGNUP_BUTTON = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private static final String HOME_PAGE_TEXT_EXPECTED = "FEATURES ITEMS";
    private static final By HOME_PAGE_TEXT_ACTUAL = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/h2");
    public final By LOGOUT_BUTTON = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private static final By NAME_ACTUAL = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");
    private static final String NAME_EXPECTED = storeFullName();
    private static final By IFRAME = By.cssSelector("#aswift_1");
    private static final By IFRAME_DISMISS = By.cssSelector("#dismiss-button");
    private static final String ACCOUNT_CREATED_TEXT_EXPECTED = "ACCOUNT CREATED!";
    private static final By ACCOUNT_CREATED_TEXT_ACTUAL = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private final By USER_IS_LOGGED = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    //endregion

    public static void openPage() {
        enterWebPage(URL);
    }

    public void pageCheck() {
        checkElementIsCorrect(
                HOME_PAGE_TEXT_ACTUAL, HOME_PAGE_TEXT_EXPECTED);
    }

    public static void clickSignupLoginButton() {
        clickButton(LOGIN_SIGNUP_BUTTON);
    }

    public void clickLogoutButton() {
        clickButton(LOGOUT_BUTTON);
    }


    public static void accountCreatedConfirmation() {
        checkElementIsCorrect(ACCOUNT_CREATED_TEXT_ACTUAL, ACCOUNT_CREATED_TEXT_EXPECTED);
        clickButton(CONTINUE_BUTTON);
        dismissIFrame(IFRAME, IFRAME_DISMISS);
        checkElementIsCorrect(NAME_ACTUAL, NAME_EXPECTED);
    }

    public void loggedInConfirmation() {
        checkElementIsDisplayed(USER_IS_LOGGED);
    }
}
