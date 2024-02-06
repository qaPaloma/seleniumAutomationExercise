package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import runner.RunBase;
import static support.Commands.*;
import static support.UserDataUtils.*;
import static pages.LoginSignupPage.*;
import static pages.HomePage.*;

public class CreateAccountPage extends RunBase {

    //region constants
    public static final String URL = "https://automationexercise.com/login";
    private final By TITLE_MR_FIELD = By.id("id_gender1");
    private final By TITLE_MRS_FIELD = By.id("id_gender2");
    private static final By PASSWORD_FIELD = By.id("password");
    private final By BIRTH_DAY_FIELD = By.id("days");
    private final By BIRTH_MONTH_FIELD = By.id("months");
    private final By BIRTH_YEAR_FIELD = By.id("years");
    private final By NEWSLETTER_FIELD = By.id("newsletter");
    private final By SPECIAL_OFFERS_FIELD = By.id("optin");
    private final By FIRST_NAME_FIELD = By.id("first_name");
    private final By LAST_NAME_FIELD = By.id("last_name");
    private final By COMPANY_FIELD = By.id("company");
    private final By ADDRESS1_FIELD = By.id("address1");
    private final By ADDRESS2_FIELD = By.id("address2");
    private final By COUNTRY_FIELD = By.id("country");
    private final By STATE_FIELD = By.id("state");
    private final By CITY_FIELD = By.id("city");
    private final By ZIPCODE_FIELD = By.id("zipcode");
    private final By MOBILE_NUMBER_FIELD = By.id("mobile_number");
    private final By CREATE_ACCOUNT_BUTTON = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button");
    private final String NAME_EXPECTED = storeFullName();
    private final By NAME_ACTUAL = By.id("name");
    private final String EMAIL_EXPECTED = storeEmail();
    private final By EMAIL_ACTUAL = By.id("email");
    public static final String GET_PASSWORD = getRandomPassword();
    //endregion

    public static void openPage() {
        enterWebPage(URL);
    }

    public void pageCheck() {
        checkElementIsDisplayed(CREATE_ACCOUNT_BUTTON);
    }

    public void checkUserName() {
        checkElementIsCorrect(NAME_ACTUAL, NAME_EXPECTED);
    }

    public void checkUserEmail() {
        checkElementIsCorrect(EMAIL_ACTUAL, EMAIL_EXPECTED);
    }

    public void addTitle() {
        selectOption(TITLE_MR_FIELD, TITLE_MRS_FIELD);
    }

    //Stores the password added during Signup, so it can be used later when testing deleting an account
    public static String storePassword() {
        return GET_PASSWORD;
    }

    public static void addPassword() {
        fillField(PASSWORD_FIELD, storePassword());
    }

    public void addYearOfBirth() {
        WebElement selectYear = getDriver().findElement(BIRTH_YEAR_FIELD);
        Select select = new Select(selectYear);
        select.selectByIndex(getRandomNumber(1, 122));
    }

    public void addMonthOfBirth() {
        WebElement selectMonth = getDriver().findElement(BIRTH_MONTH_FIELD);
        Select select = new Select(selectMonth);
        select.selectByIndex(getRandomNumber(1, 12));
    }

    public void addDayOfBirth() {
        WebElement selectDay = getDriver().findElement(BIRTH_DAY_FIELD);
        Select select = new Select(selectDay);
        select.selectByIndex(getRandomNumber(1, 31));
    }

    public void selectNewsletter() {
        clickButton(NEWSLETTER_FIELD);
    }

    public void selectReceiveOffers() {
        clickButton(SPECIAL_OFFERS_FIELD);
    }

    public void addFirstName() {
        fillField(FIRST_NAME_FIELD, storeFirstName());
    }

    public void addLastName() {
        fillField(LAST_NAME_FIELD, storeLastName());
    }

    public void addCompanyName() {
        fillField(COMPANY_FIELD, "Test Company INC.");
    }

    public void addAddress1() {
        fillField(ADDRESS1_FIELD, "Test St. 980 NY");
    }

    public void addAddress2() {
        fillField(ADDRESS2_FIELD, "Test neighborhood");
    }

    public void addCountry() {
        WebElement selectCountry = getDriver().findElement(COUNTRY_FIELD);
        Select select = new Select(selectCountry);
        select.selectByIndex(getRandomNumber(1, 7));
    }

    public void addState() {
        fillField(STATE_FIELD, "Test State");
    }

    public void addCity() {
        fillField(CITY_FIELD, "Testown");
    }

    public void addZipcode() {
        fillField(ZIPCODE_FIELD, getRandomNumber(5));
    }

    public void addMobileNumber() {
        fillField(MOBILE_NUMBER_FIELD, getRandomNumber(10));
    }


    public void clickCreateButton() {
        clickButton(CREATE_ACCOUNT_BUTTON);
    }

    public void addUserData() {
        addTitle();
        addPassword();
        addDayOfBirth();
        addMonthOfBirth();
        addYearOfBirth();
        selectNewsletter();
        selectReceiveOffers();
        addFirstName();
        addLastName();
        addCompanyName();
        addAddress1();
        addAddress2();
        addCountry();
        addState();
        addCity();
        addZipcode();
        addMobileNumber();
    }

    public void completeSignup() {
        openPage();
        clickSignupLoginButton();
        pageCheck();
        addName();
        addSignupEmail();
        clickSignupButton();
        addUserData();
        clickCreateButton();
        HomePage.accountCreatedConfirmation();
    }

}
