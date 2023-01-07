package step_definitions;

import com.microsoft.playwright.*;
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
        login.enterEmail(email);
        login.enterPassword(pass);
       /* login.loginIntoApplication(email,pass);*/
        // verify if the email and login are correct if possible (assert true get element)
    }

    @And("I clicks to the logout button")
    public void logoutapp() {
        login.logoutButton();}

    @Then("I'm logout")
    public void imlogout() {
        login.saveScreen();
        assert pager.url().equals("https://ztrain-web.vercel.app/home");
        login.saveScreen();
        //home.waittime();
    }


    @And("I login into app with email address {string} and password {string}")
    public void loginIntoTheApplication1(String email,String pass ) {
//        login.enterEmail(email);
//        login.enterPassword(pass);
        login.loginIntoApplication(email,pass);
        // verify if the email and login are correct if possible (assert true get element)
    }


    @And("I clicks to the login button")
    public void iClicksToTheLoginButton() {
        login.clickLoginButton();
    }

    @Then("The user is connected, the {string} logo is observed")
    public void theUserIsConnectedWith(String confirmationLogin) {
        login.saveScreen();
        String confirmation = login.getLogoHomepage();
        login.saveScreen();
        Assert.assertEquals("Failed to login because 'E-mail or password incorrect' : \n" +
                "--> after more 30s of waiting exceeded  we did not find the Ztrain logo indicating the presence on the homepage and an effective connection of the user)\n" +
                "-->",confirmationLogin,confirmation);
    }



    @Then("Access is denied with the message {string}")
    public void accessIsDeniedWithTheMessage(String failedLogin) {
        login.saveScreen();
        String failed = login.getFailedLogin();
        login.saveScreen();
        Assert.assertEquals("this test case is not passed because\n" +
                "-> after more 30s of waiting exceeded we did not find this error message 'Incorrect email or password'\n" +
                "->",failedLogin,failed);

    }

    @Then("Access is denied with {string}")
    public void accessIsDeniedWith(String fail_email) {
        login.saveScreen();
        String fail = login.getFail_email();
        login.saveScreen();
        Assert.assertEquals("this test case is not passed because\n" +
                "-> after more 30s of waiting exceeded we did not find this error message 'The email format is invalid'\n" +
                "->",fail,fail_email);
    }


}
