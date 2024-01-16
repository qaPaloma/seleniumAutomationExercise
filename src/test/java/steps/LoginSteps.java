package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginSignupPage;
import runner.RunCucumberTest;
import support.ScreenshotUtils;

public class LoginSteps extends RunCucumberTest  {
    LoginSignupPage loginSignupPage = new LoginSignupPage();
    HomePage homePage = new HomePage();

    @Given("the user is on the store's page")
    public void pageCheck(){
        HomePage.openPage();
        homePage.pageCheck();
    }

    @And("they click on the signup and login button")
    public void clickSignupLoginButton(){
        HomePage.clickSignupLoginButton();
        LoginSignupPage.pageCheck();
    }

    @When("the user enters their email {string} and password {string} on the login section")
    public void loginData(String user, String password){
        loginSignupPage.addLoginEmail(user);
        loginSignupPage.addLoginPassword(password);
    }

    @And("clicks on the login button")
    public void loginButton(){
        loginSignupPage.clickLoginButton();
    }

    @Then("the user is logged to the website")
    public void loginSuccess(){
        homePage.loggedInConfirmation();
    }

    @Then("the user sees an error {string}")
    public void errorMessage(String arg0) {
        loginSignupPage.errorMessageCheck(arg0);
        System.out.println(arg0);
    }


    @After
    public static void takeScreenshotWhenTestFails(Scenario scenario){
        if (scenario.isFailed()){
            ScreenshotUtils.takeScreenshot(scenario);
        }
    }
}
