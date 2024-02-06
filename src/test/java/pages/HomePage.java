package pages;

import org.openqa.selenium.By;
import runner.RunBase;
import static pages.LoginSignupPage.*;
import static support.Commands.*;

public class HomePage extends RunBase {

    //region constants
    public static final String URL = "https://automationexercise.com/";
    private static final By LOGIN_SIGNUP_BUTTON = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final String PAGE_TITLE = "Automation Exercise";
    public final By LOGOUT_BUTTON = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private static final By NAME_ACTUAL = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b");
    private static final String NAME_EXPECTED = storeFullName();
    private static final By IFRAME = By.cssSelector("#aswift_1");
    private static final By IFRAME_DISMISS = By.cssSelector("#dismiss-button");
    private final By DELETE_BUTTON = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private final String ACCOUNT_DELETED_TEXT_EXPECTED = "ACCOUNT DELETED!";
    private final By ACCOUNT_DELETED_TEXT_ACTUAL = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private static final String ACCOUNT_CREATED_TEXT_EXPECTED = "ACCOUNT CREATED!";
    private static final By ACCOUNT_CREATED_TEXT_ACTUAL = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private final By USER_IS_LOGGED = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    //endregion

    public static void openPage() {
        enterWebPage(URL);
    }

    public void pageCheck() {
        checkPageTitle(PAGE_TITLE);
    }

    public static void clickSignupLoginButton() {
        clickButton(LOGIN_SIGNUP_BUTTON);
    }

    public void clickLogoutButton() {
        clickButton(LOGOUT_BUTTON);
    }

    public void deleteButton() {
        clickButton(DELETE_BUTTON);
    }

    public void deleteConfirmation() {
        checkElementIsCorrect(
                ACCOUNT_DELETED_TEXT_ACTUAL, ACCOUNT_DELETED_TEXT_EXPECTED);
        clickButton(CONTINUE_BUTTON);
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
