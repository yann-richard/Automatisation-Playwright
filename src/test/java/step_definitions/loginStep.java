package step_definitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
//import org.testng.Assert;
import page_object.homePage;
import page_object.loginPage;
import static Runners.BaseRunner.*;




public class loginStep {
    loginPage login;
    homePage home;



    @Given("I open Ztrain login page")
    public void iOpenZtrainLoginPage() {
        pager.navigate("https://ztrain-web.vercel.app/auth/login");
        login = new loginPage(pager);

    }



    @When("I'm in the login page")
    public void iMInTheLoginPage() {
        //verify if is login page (assert true)
    }

    @And("I enter email address {string} and password {string}")
    public void loginIntoTheApplication(String email,String pass ) {
        login.enterEmail(email); login.enterPassword(pass);
        // verify if the email and login are correct if possible (assert true get element)
    }


    @And("I clicks to the login button")
    public void iClicksToTheLoginButton() {
        login.clickLoginButton();
    }

    @Then("The user is connected with  {string}")
    public void theUserIsConnectedWith(String confirmationLogin) {
        login.saveScreen();
        String confirmation = login.getLogoHomepage();
        login.saveScreen();
        Assert.assertEquals(confirmation,confirmationLogin);
    }

    @Then("Access is denied with the message {string}")
    public void accessIsDeniedWithTheMessage(String failedLogin) {
        login.saveScreen();
        String failed = login.getFailedLogin();
        login.saveScreen();
        Assert.assertEquals(failed,failedLogin);
    }

    @Then("Access is denied with {string}")
    public void accessIsDeniedWith(String fail_email) {
        login.saveScreen();
        String fail = login.getFail_email();
        Assert.assertEquals(fail,fail_email);
        login.saveScreen();
    }


}
