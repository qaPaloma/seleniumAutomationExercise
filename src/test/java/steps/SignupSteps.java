package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginSignupPage;
import runner.RunCucumberTest;
import support.ScreenshotUtils;

public class SignupSteps extends RunCucumberTest {
    CreateAccountPage createAccountPage = new CreateAccountPage();
    LoginSignupPage loginSignupPage= new LoginSignupPage();

    @And("the user enters their name and email on the signup section")
    public void signupData() {
        LoginSignupPage.addName();
        LoginSignupPage.addSignupEmail();
    }


    @And("clicks the signup button")
    public void signupButton() {
        LoginSignupPage.clickSignupButton();
    }


    @And("goes to the account information page")
    public void informationPageCheck() {
        createAccountPage.pageCheck();
    }

    @When("the user adds their information")
    public void accountData() {
        createAccountPage.checkUserName();
        createAccountPage.checkUserEmail();
        createAccountPage.addUserData();
    }

    @And("clicks on the create account button")
    public void createAccountButton() {
        createAccountPage.clickCreateButton();
    }


    @Then("the user sees a signup confirmation message")
    public void confirmationMessage() {
        HomePage.accountCreatedConfirmation();
    }

/*SIGNUP ERROR*/

    @When("the user enters their name and <{string}> on the signup section")
    public void enterExistingEmail(String arg0) {
        LoginSignupPage.addName();
        loginSignupPage.trySignupWithExistingEmail(arg0);
    }

    @Then("the user sees an error message")
    public void errorMessage() {
        loginSignupPage.errorMessageSignup();
    }


    @After
    public static void takeScreenshotWhenTestFails(Scenario scenario){
        if (scenario.isFailed()){
            ScreenshotUtils.takeScreenshot(scenario);
        }
    }
}
