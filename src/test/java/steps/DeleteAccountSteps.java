package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginSignupPage;
import runner.RunCucumberTest;
import support.ScreenshotUtils;

public class DeleteAccountSteps extends RunCucumberTest {
    CreateAccountPage createAccountPage = new CreateAccountPage();
    HomePage homePage = new HomePage();
    LoginSignupPage loginSignupPage = new LoginSignupPage();

    @Given("the user has created an account on the website")
    public void createAccount(){
        createAccountPage.completeSignup();
    }

    @And("they are in the store's homepage")
    public void pageCheck(){
        homePage.pageCheck();
    }

    @When("they click on the delete account button")
    public void clickDeleteButton(){
        homePage.deleteButton();
    }

    @Then("the user sees a delete confirmation message")
    public void confirmationMessage(){
        homePage.deleteConfirmation();
    }

    @And("the user can no longer log in to the website")
    public void loginAttempt(){
        HomePage.clickSignupLoginButton();

        loginSignupPage.tryLoginWithDeleteAccount();
        loginSignupPage.clickLoginButton();
    }

    @After
    public static void takeScreenshotWhenTestFails(Scenario scenario){
        if (scenario.isFailed()){
            ScreenshotUtils.takeScreenshot(scenario);
        }
    }
}
