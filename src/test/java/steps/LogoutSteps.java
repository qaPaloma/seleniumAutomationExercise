package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginSignupPage;
import runner.RunCucumberTest;
import support.ScreenshotUtils;

public class LogoutSteps extends RunCucumberTest {
    LoginSignupPage loginSignupPage = new LoginSignupPage();
    HomePage homePage = new HomePage();

    @Given("the user is logged in to the website")
    public void userLogged(){
        loginSignupPage.completeLogin();
    }

    @When ("the user clicks on the Logout button")
    public void logoutButton(){
        homePage.clickLogoutButton();
    }

    @Then("the user is taken to the Login page")
    public void pageCheck(){
        LoginSignupPage.pageCheck();
    }


    @After
    public static void takeScreenshotWhenTestFails(Scenario scenario){

        if (scenario.isFailed()){
            ScreenshotUtils.takeScreenshot(scenario);
        }
    }
}
