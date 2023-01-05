package step_definitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object.loginPage;


public class StepDef_login {
    loginPage login;
    Playwright playwright = Playwright.create();
    BrowserType firefox = playwright.chromium( );
    Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();



    @Given("i open Ztrain login page")
    public void iOpenZtrainLoginPage() {
        page.navigate("https://ztrain-web.vercel.app/auth/login");
        login = new loginPage(page);
    }

    @When("I'm in the login page")
    public void iMInTheLoginPage() {
    }

    @And("I enter email address {string} and password {string}")
    public void loginIntoTheApplication(String email,String pass ) {
        login.enterEmail(email); login.enterPassword(pass);
    }


    @And("I clicks to the login button")
    public void iClicksToTheLoginButton() {
        login.clickLoginButton();
    }


    @Then("The user is connected")
    public void theUserIsConnected() {
    }


}
